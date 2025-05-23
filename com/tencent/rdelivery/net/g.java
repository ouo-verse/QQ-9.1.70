package com.tencent.rdelivery.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.DataManager;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.net.RDeliveryRequest;
import iz3.l;
import iz3.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002\u0003\u0006B/\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J-\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0013\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/rdelivery/net/g;", "", "", "a", "Lcom/tencent/rdelivery/data/DataManager;", "manager", "b", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "src", "Liz3/e;", "listener", "", "mergeReqId", "d", "(Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;Liz3/e;Ljava/lang/Long;)V", "", "", "keys", "Liz3/l;", "f", WadlProxyConsts.SCENE_ID, "Liz3/b;", "c", "Lcom/tencent/rdelivery/net/ReqFreqLimiter;", "Lcom/tencent/rdelivery/net/ReqFreqLimiter;", "reqFreqLimiter", "Lcom/tencent/rdelivery/net/e;", "Lcom/tencent/rdelivery/net/e;", "requestDispatcher", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "getSetting", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Landroid/content/Context;", "Landroid/content/Context;", "context", "dataManager", "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "<init>", "(Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/rdelivery/data/DataManager;Lcom/tencent/raft/standard/net/IRNetwork;Lcom/tencent/raft/standard/task/IRTask;Landroid/content/Context;)V", "e", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private ReqFreqLimiter reqFreqLimiter;

    /* renamed from: b, reason: from kotlin metadata */
    private e requestDispatcher;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* renamed from: d, reason: from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/net/g$a;", "", "Lorg/json/JSONObject;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "extraTag", "Lcom/tencent/rdelivery/util/c;", "logger", "", "doPrintLog", "Lcom/tencent/rdelivery/data/RDeliveryData;", "a", "HTTP_HEADER_KEY_CONTENT_TYPE", "Ljava/lang/String;", "JSON_CONTENT_TYPE", "SERVER_URL_PRE_RELEASE", "SERVER_URL_PRE_RELEASE_ENCRYPT", "SERVER_URL_RELEASE", "SERVER_URL_RELEASE_ENCRYPT", "SERVER_URL_TEST", "SERVER_URL_TEST_ENCRYPT", "TAG", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.g$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ RDeliveryData b(Companion companion, JSONObject jSONObject, String str, com.tencent.rdelivery.util.c cVar, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                cVar = null;
            }
            if ((i3 & 8) != 0) {
                z16 = true;
            }
            return companion.a(jSONObject, str, cVar, z16);
        }

        @NotNull
        public final RDeliveryData a(@NotNull JSONObject r65, @Nullable String extraTag, @Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog) {
            String str;
            Intrinsics.checkParameterIsNotNull(r65, "item");
            Object obj = r65.get("key");
            if (obj != null) {
                RDeliveryData rDeliveryData = new RDeliveryData((String) obj);
                rDeliveryData.w(r65.toString());
                String optString = r65.optString("debugInfo");
                Intrinsics.checkExpressionValueIsNotNull(optString, "item.optString(BaseProto.Config.KEY_DEBUGINFO)");
                rDeliveryData.u(optString);
                JSONObject optJSONObject = r65.optJSONObject("report");
                if (optJSONObject == null || (str = optJSONObject.optString("hitSubTaskID")) == null) {
                    str = "";
                }
                rDeliveryData.v(str);
                rDeliveryData.r(r65.optJSONObject("bizContent"));
                String optString2 = r65.optString("value", null);
                if (TextUtils.isEmpty(optString2)) {
                    return rDeliveryData;
                }
                if (optString2 != null) {
                    JSONObject jSONObject = new JSONObject(optString2);
                    int optInt = jSONObject.optInt("config_value_type");
                    String optString3 = jSONObject.optString("config_value");
                    Intrinsics.checkExpressionValueIsNotNull(optString3, "portalConfig.optString(B\u2026o.PortalConfig.KEY_VALUE)");
                    int optInt2 = jSONObject.optInt("switch_state");
                    rDeliveryData.s(optString3);
                    rDeliveryData.t(BaseProto$ValueType.INSTANCE.a(optInt));
                    if (optInt2 == BaseProto$Switch.NOSWITCH.getValue()) {
                        rDeliveryData.x(null);
                    } else if (optInt2 == BaseProto$Switch.ON.getValue()) {
                        rDeliveryData.x(Boolean.TRUE);
                    } else if (optInt2 == BaseProto$Switch.OFF.getValue()) {
                        rDeliveryData.x(Boolean.FALSE);
                    }
                }
                if (logger != null) {
                    logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", extraTag), "decodeRDDataFromJson key = " + rDeliveryData.getKey() + ",debugInfo = " + rDeliveryData.getDebugInfo() + ",switchValue = " + rDeliveryData.getSwitchValue() + ",hitSubTaskID = " + rDeliveryData.getHitSubTaskID() + ",bizContent = " + rDeliveryData.getBizContent(), doPrintLog);
                }
                return rDeliveryData;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J2\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/rdelivery/net/g$b;", "Liz3/e;", "", "onSuccess", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "updatedDatas", "deletedDatas", "a", "", "reason", "onFail", "Liz3/e;", "originListener", "b", "customListener", "<init>", "(Liz3/e;Liz3/e;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements iz3.e {

        /* renamed from: a, reason: from kotlin metadata */
        private final iz3.e originListener;

        /* renamed from: b, reason: from kotlin metadata */
        private final iz3.e customListener;

        public b(@Nullable iz3.e eVar, @Nullable iz3.e eVar2) {
            this.originListener = eVar;
            this.customListener = eVar2;
        }

        @Override // iz3.e, iz3.m
        public void a(@NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas) {
            Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
            Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
            Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
            iz3.e eVar = this.originListener;
            if (eVar != null) {
                eVar.a(remainedDatas, updatedDatas, deletedDatas);
            }
            iz3.e eVar2 = this.customListener;
            if (eVar2 != null) {
                eVar2.a(remainedDatas, updatedDatas, deletedDatas);
            }
        }

        @Override // iz3.m
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            iz3.e eVar = this.originListener;
            if (eVar != null) {
                eVar.onFail(reason);
            }
            iz3.e eVar2 = this.customListener;
            if (eVar2 != null) {
                eVar2.onFail(reason);
            }
        }

        @Override // iz3.e
        public void onSuccess() {
            iz3.e eVar = this.originListener;
            if (eVar != null) {
                eVar.onSuccess();
            }
            iz3.e eVar2 = this.customListener;
            if (eVar2 != null) {
                eVar2.onSuccess();
            }
        }
    }

    public g(@NotNull RDeliverySetting setting, @NotNull DataManager dataManager, @NotNull IRNetwork netInterface, @NotNull IRTask taskInterface, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
        Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.setting = setting;
        this.context = context;
        this.reqFreqLimiter = new ReqFreqLimiter(context, setting, taskInterface);
        this.requestDispatcher = new e(setting, dataManager, netInterface, taskInterface);
    }

    private final synchronized void a() {
        if (TextUtils.isEmpty(this.setting.getUuid())) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", this.setting.getRdInstanceIdentifier()), "ensureInitUuid", false, 4, null);
            }
            this.setting.O(this.context);
        }
    }

    public static /* synthetic */ void e(g gVar, RDeliveryRequest.RequestSource requestSource, iz3.e eVar, Long l3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eVar = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        gVar.d(requestSource, eVar, l3);
    }

    public final void b(@NotNull DataManager manager) {
        Intrinsics.checkParameterIsNotNull(manager, "manager");
        this.requestDispatcher.e(manager);
    }

    public final void c(long r102, @NotNull iz3.b listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        a();
        RDeliveryRequest b16 = RDeliveryRequest.Companion.b(RDeliveryRequest.INSTANCE, this.setting, r102, listener, null, 8, null);
        synchronized (this.reqFreqLimiter) {
            if (this.reqFreqLimiter.j(b16.getPullType())) {
                m listener2 = b16.getListener();
                if (listener2 != null) {
                    listener2.onFail("req_freq_limit");
                }
                com.tencent.rdelivery.util.c logger = this.setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", this.setting.getRdInstanceIdentifier()), "requestBatchRemoteData limited, return", false, 4, null);
                }
                return;
            }
            this.reqFreqLimiter.i(b16.getPullType());
            Unit unit = Unit.INSTANCE;
            this.requestDispatcher.c(b16);
            this.requestDispatcher.i();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull RDeliveryRequest.RequestSource src, @Nullable iz3.e listener, @Nullable Long mergeReqId) {
        RDeliveryRequest c16;
        long j3;
        Long longOrNull;
        Intrinsics.checkParameterIsNotNull(src, "src");
        a();
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", this.setting.getRdInstanceIdentifier()), "requestFullRemoteData src = " + src, false, 4, null);
        }
        b bVar = new b(listener, this.setting.getUsrCustomListener());
        if (this.setting.X()) {
            String fixedSceneId = this.setting.getFixedSceneId();
            if (fixedSceneId != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            c16 = RDeliveryRequest.INSTANCE.a(this.setting, j3, bVar, mergeReqId);
        } else {
            c16 = RDeliveryRequest.INSTANCE.c(this.setting, src, bVar, mergeReqId);
        }
        synchronized (this.reqFreqLimiter) {
            if (this.reqFreqLimiter.j(c16.getPullType())) {
                m listener2 = c16.getListener();
                if (listener2 != null) {
                    listener2.onFail("req_freq_limit");
                }
                if (mergeReqId != null) {
                    h.f364359c.c(mergeReqId.longValue(), this.setting);
                }
                com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
                if (logger2 != null) {
                    com.tencent.rdelivery.util.c.b(logger2, com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", this.setting.getRdInstanceIdentifier()), "requestFullRemoteData limited, return", false, 4, null);
                }
                return;
            }
            this.reqFreqLimiter.i(c16.getPullType());
            Unit unit = Unit.INSTANCE;
            this.requestDispatcher.c(c16);
            this.requestDispatcher.i();
        }
    }

    public final void f(@NotNull List<String> keys, @NotNull l listener) {
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        a();
        RDeliveryRequest d16 = RDeliveryRequest.INSTANCE.d(this.setting, keys, listener);
        synchronized (this.reqFreqLimiter) {
            if (this.reqFreqLimiter.j(d16.getPullType())) {
                m listener2 = d16.getListener();
                if (listener2 != null) {
                    listener2.onFail("req_freq_limit");
                }
                com.tencent.rdelivery.util.c logger = this.setting.getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_RequestManager", this.setting.getRdInstanceIdentifier()), "requestMultiRemoteData limited, return", false, 4, null);
                }
                return;
            }
            this.reqFreqLimiter.i(d16.getPullType());
            Unit unit = Unit.INSTANCE;
            this.requestDispatcher.c(d16);
            this.requestDispatcher.i();
        }
    }
}
