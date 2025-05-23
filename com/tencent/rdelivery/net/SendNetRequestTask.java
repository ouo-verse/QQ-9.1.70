package com.tencent.rdelivery.net;

import android.os.SystemClock;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.DataManager;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.net.e;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.util.RightlyHelper;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import iz3.m;
import iz3.q;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001VB7\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010Q\u001a\u00020\u0002\u0012\u0006\u0010D\u001a\u00020@\u0012\u0006\u0010J\u001a\u00020E\u0012\u0006\u0010P\u001a\u00020K\u0012\u0006\u0010R\u001a\u00020\u0006\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J[\u0010 \u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020&0(2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010,\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u001c\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u0004H\u0016J\u000e\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010:R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010:R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010D\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010J\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010P\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\u00a8\u0006W"}, d2 = {"Lcom/tencent/rdelivery/net/SendNetRequestTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/data/DataManager;", "dm", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "tmpServerContext", "o", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "result", "", "y", "Lorg/json/JSONObject;", "response", "Lkotlin/Triple;", "l", "Lorg/json/JSONArray;", "i", tl.h.F, Constants.Configs.CONFIGS, "hitSubTaskTags", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/security/Key;", "aesKey", DomainData.DOMAIN_NAME, "systemBizData", "context", "isOverwrite", "", "serverTime", "j", "(Lcom/tencent/rdelivery/data/DataManager;Lcom/tencent/rdelivery/net/RDeliveryRequest;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/lang/String;ZLjava/lang/Long;)Z", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "", "t", "updatedDatas", "deletedDatas", "k", "r", "f", "g", TencentLocation.RUN_MODE, "", "content", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d", "Z", "hasNextServerData", "e", "Ljava/lang/String;", "segmentRespServerContext", "Lorg/json/JSONArray;", "totalConfigs", "totalHitSubTaskTags", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "u", "()Lcom/tencent/rdelivery/net/RDeliveryRequest;", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "v", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/raft/standard/net/IRNetwork;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/raft/standard/net/IRNetwork;", "getNetInterface", "()Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/rdelivery/net/e$b;", "D", "Lcom/tencent/rdelivery/net/e$b;", "w", "()Lcom/tencent/rdelivery/net/e$b;", "taskResultListener", "dataManager", "taskName", "<init>", "(Lcom/tencent/rdelivery/net/RDeliveryRequest;Lcom/tencent/rdelivery/data/DataManager;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/raft/standard/net/IRNetwork;Lcom/tencent/rdelivery/net/e$b;Ljava/lang/String;)V", "E", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class SendNetRequestTask extends IRTask.WeakReferenceTask<DataManager> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IRNetwork netInterface;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e.b taskResultListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasNextServerData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String segmentRespServerContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private JSONArray totalConfigs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private JSONArray totalHitSubTaskTags;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliveryRequest request;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/net/SendNetRequestTask$b", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "", "result", "", "onSuccess", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements IRNetwork.INetworkResult {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataManager f364298b;

        b(DataManager dataManager) {
            this.f364298b = dataManager;
        }

        @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
        public void onFail(@NotNull IRNetwork.ResultInfo result) {
            Intrinsics.checkParameterIsNotNull(result, "result");
            com.tencent.rdelivery.util.c logger = SendNetRequestTask.this.getSetting().getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", SendNetRequestTask.this.getSetting().getRdInstanceIdentifier()), "SendRequestTask onFail", SendNetRequestTask.this.getSetting().getEnableDetailLog());
            }
            SendNetRequestTask sendNetRequestTask = SendNetRequestTask.this;
            sendNetRequestTask.x(sendNetRequestTask.getRequest(), result);
            SendNetRequestTask.this.getTaskResultListener().a(false, SendNetRequestTask.this.getRequest(), result.getErrorMessage());
        }

        @Override // com.tencent.raft.standard.net.IRNetwork.INetworkResult
        public void onSuccess(@NotNull Object result) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(result, "result");
            com.tencent.rdelivery.util.c logger = SendNetRequestTask.this.getSetting().getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", SendNetRequestTask.this.getSetting().getRdInstanceIdentifier()), "SendRequestTask onSuccess = " + result + "\uff0chasNext = " + SendNetRequestTask.this.hasNextServerData, SendNetRequestTask.this.getSetting().getEnableDetailLog());
            }
            SendNetRequestTask sendNetRequestTask = SendNetRequestTask.this;
            RDeliveryRequest request = sendNetRequestTask.getRequest();
            boolean z16 = result instanceof String;
            if (!z16) {
                obj = null;
            } else {
                obj = result;
            }
            boolean y16 = sendNetRequestTask.y(request, (String) obj, this.f364298b);
            if (SendNetRequestTask.this.hasNextServerData && y16) {
                SendNetRequestTask sendNetRequestTask2 = SendNetRequestTask.this;
                sendNetRequestTask2.o(this.f364298b, sendNetRequestTask2.segmentRespServerContext);
                return;
            }
            e.b taskResultListener = SendNetRequestTask.this.getTaskResultListener();
            RDeliveryRequest request2 = SendNetRequestTask.this.getRequest();
            if (!z16) {
                result = null;
            }
            taskResultListener.a(true, request2, (String) result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/net/SendNetRequestTask$c", "Liz3/j;", "", "v2Response", "", "cancelMergeRequest", "", "a", "reason", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c implements iz3.j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataManager f364300b;

        c(DataManager dataManager) {
            this.f364300b = dataManager;
        }

        @Override // iz3.j
        public void a(@Nullable String v2Response, boolean cancelMergeRequest) {
            if (cancelMergeRequest) {
                SendNetRequestTask.p(SendNetRequestTask.this, this.f364300b, null, 2, null);
                return;
            }
            SendNetRequestTask sendNetRequestTask = SendNetRequestTask.this;
            boolean y16 = sendNetRequestTask.y(sendNetRequestTask.getRequest(), v2Response, this.f364300b);
            if (SendNetRequestTask.this.hasNextServerData && y16) {
                SendNetRequestTask sendNetRequestTask2 = SendNetRequestTask.this;
                sendNetRequestTask2.o(this.f364300b, sendNetRequestTask2.segmentRespServerContext);
            } else {
                SendNetRequestTask.this.getTaskResultListener().a(true, SendNetRequestTask.this.getRequest(), v2Response);
            }
        }

        @Override // iz3.j
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            m listener = SendNetRequestTask.this.getRequest().getListener();
            if (listener != null) {
                listener.onFail(reason);
            }
            com.tencent.rdelivery.report.c.f364376c.k(SendNetRequestTask.this.getRequest(), false, "40", "", reason, SendNetRequestTask.this.getSetting());
            SendNetRequestTask.this.getTaskResultListener().a(false, SendNetRequestTask.this.getRequest(), "");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendNetRequestTask(@NotNull RDeliveryRequest request, @NotNull DataManager dataManager, @NotNull RDeliverySetting setting, @NotNull IRNetwork netInterface, @NotNull e.b taskResultListener, @NotNull String taskName) {
        super(dataManager, taskName, IRTask.Priority.NORMAL_PRIORITY);
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
        Intrinsics.checkParameterIsNotNull(taskResultListener, "taskResultListener");
        Intrinsics.checkParameterIsNotNull(taskName, "taskName");
        this.request = request;
        this.setting = setting;
        this.netInterface = netInterface;
        this.taskResultListener = taskResultListener;
        this.totalConfigs = new JSONArray();
        this.totalHitSubTaskTags = new JSONArray();
    }

    private final boolean f(RDeliveryRequest request) {
        return !Intrinsics.areEqual(request.getLogicEnvironment(), this.setting.getLogicEnvironment());
    }

    private final boolean g(RDeliveryRequest request) {
        return !Intrinsics.areEqual(request.getUserId(), this.setting.getUserId());
    }

    private final JSONArray h(JSONObject response) {
        JSONArray jSONArray;
        if (response != null) {
            jSONArray = response.optJSONArray(Constants.Configs.CONFIGS);
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                this.totalConfigs.mo162put(jSONArray.get(i3));
            }
        }
        return jSONArray;
    }

    private final JSONArray i(JSONObject response) {
        JSONArray jSONArray;
        if (response != null) {
            jSONArray = response.optJSONArray("hitSubTaskTag");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                this.totalHitSubTaskTags.mo162put(jSONArray.get(i3));
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        com.tencent.rdelivery.util.a.f364654d.k(r19, r14.setting);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #0 {Exception -> 0x008d, blocks: (B:3:0x0017, B:5:0x0045, B:8:0x004e, B:10:0x0056, B:11:0x006c, B:15:0x0082, B:17:0x0088, B:21:0x007d, B:23:0x0065), top: B:2:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean j(DataManager dm5, RDeliveryRequest request, JSONObject systemBizData, JSONArray configs, JSONArray hitSubTaskTags, String context, boolean isOverwrite, Long serverTime) {
        m listener;
        List<RDeliveryData> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            m(systemBizData);
            k(configs, arrayList, arrayList2, arrayList3);
            dm5.O(context, arrayList, arrayList2, arrayList3, request.getUserId(), request.getLogicEnvironment(), isOverwrite);
            dm5.T(request, arrayList, arrayList2, arrayList3, serverTime);
            if (request.getPullType() != BaseProto$PullType.ALL && !this.setting.X()) {
                com.tencent.rdelivery.util.c logger = this.setting.getLogger();
                if (logger != null) {
                    logger.a("RDelivery_SendNetRequestTask", "decodeAndSaveRespData ignore tags", this.setting.getEnableDetailLog());
                }
                boolean X = this.setting.X();
                if (this.setting.V() || !X) {
                    arrayList = t(arrayList, dm5);
                }
                listener = request.getListener();
                if (listener != null) {
                    listener.a(arrayList, arrayList2, arrayList3);
                }
                return true;
            }
            boolean X2 = this.setting.X();
            if (this.setting.V()) {
            }
            arrayList = t(arrayList, dm5);
            listener = request.getListener();
            if (listener != null) {
            }
            return true;
        } catch (Exception e16) {
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.d(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "decodeAndSaveRespData decode fail", e16);
            }
            m listener2 = request.getListener();
            if (listener2 != null) {
                listener2.onFail("decode_fail");
            }
            return false;
        }
    }

    private final void k(JSONArray configs, List<RDeliveryData> remainedDatas, List<RDeliveryData> updatedDatas, List<RDeliveryData> deletedDatas) {
        com.tencent.rdelivery.util.c logger;
        if (configs != null) {
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "decodeJsonConfigs configs.length() = " + configs.length(), this.setting.getEnableDetailLog());
            }
            int length = configs.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject item = configs.getJSONObject(i3);
                int optInt = item.optInt("op", 0);
                g.Companion companion = g.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(item, "item");
                RDeliveryData a16 = companion.a(item, this.setting.getRdInstanceIdentifier(), this.setting.getLogger(), this.setting.getEnableDetailLog());
                BaseProto$OP baseProto$OP = BaseProto$OP.NOOP;
                if (optInt != baseProto$OP.getValue() && (logger = this.setting.getLogger()) != null) {
                    logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "decodeJsonConfigs op = " + optInt + ",key = " + a16.getKey() + ",value = " + a16.getConfigValue() + ",debugInfo = " + a16.getDebugInfo() + ", hitSubTaskID = " + a16.getHitSubTaskID(), this.setting.getEnableDetailLog());
                }
                if (optInt == BaseProto$OP.UPDATE.getValue()) {
                    updatedDatas.add(a16);
                } else if (optInt == BaseProto$OP.DELETE.getValue()) {
                    deletedDatas.add(a16);
                } else if (optInt == baseProto$OP.getValue()) {
                    remainedDatas.add(a16);
                }
            }
        }
    }

    private final Triple<Boolean, String, String> l(JSONObject response, RDeliveryRequest request, DataManager dm5) {
        int i3;
        long j3;
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        String str2;
        String str3;
        boolean z19;
        JSONObject jSONObject;
        String str4;
        com.tencent.rdelivery.util.c logger;
        boolean z26 = false;
        if (response != null) {
            i3 = response.optInt("code", 0);
        } else {
            i3 = -1;
        }
        int i16 = i3;
        long j16 = 0;
        if (response != null) {
            j3 = response.optLong("softInterval", 0L);
        } else {
            j3 = 0;
        }
        if (response != null) {
            j16 = response.optLong("hardInterval", 0L);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (response != null) {
            currentTimeMillis = response.optLong("serverTime", currentTimeMillis);
        }
        if (response != null) {
            z16 = response.optBoolean("isCfgChangeReport", false);
        } else {
            z16 = false;
        }
        this.setting.Z(z16);
        this.setting.b0(j3, j16);
        if (response != null) {
            z17 = response.optBoolean("closeBuglyReport", false);
        } else {
            z17 = false;
        }
        this.setting.Y(z17);
        int i17 = 10;
        if (response != null) {
            i17 = response.optInt("sampling", 10);
        }
        request.i0(i17);
        this.setting.a0(i17);
        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
        if (logger2 != null) {
            logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess sampling = " + i17 + ", serverTime = " + currentTimeMillis, this.setting.getEnableDetailLog());
        }
        String str5 = "";
        if (i16 == BaseProto$Code.SUCCESS.getValue()) {
            if (response != null) {
                z18 = response.optBoolean("hasNext");
            } else {
                z18 = false;
            }
            if (response != null) {
                str2 = response.optString("debugInfo");
            } else {
                str2 = null;
            }
            com.tencent.rdelivery.util.c logger3 = this.setting.getLogger();
            if (logger3 != null) {
                logger3.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext = " + z18 + ",respDebugInfo = " + str2, this.setting.getEnableDetailLog());
            }
            this.hasNextServerData = z18;
            JSONArray h16 = h(response);
            JSONArray i18 = i(response);
            if (response == null || (str3 = response.optString("context")) == null) {
                str3 = "";
            }
            if (this.hasNextServerData) {
                this.segmentRespServerContext = str3;
                z(h16, i18);
                z26 = true;
                str = "";
            } else {
                if (response != null) {
                    z19 = response.optBoolean("isOverwrite");
                } else {
                    z19 = false;
                }
                if (response != null) {
                    z26 = response.optBoolean("isRightlyFullReport");
                }
                RightlyHelper.f364646c.g(this.setting, z26);
                if (z19 && (logger = this.setting.getLogger()) != null) {
                    logger.e(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess isOverwrite", this.setting.getEnableDetailLog());
                }
                if (response != null) {
                    jSONObject = response.optJSONObject("bizData");
                } else {
                    jSONObject = null;
                }
                z26 = j(dm5, request, jSONObject, this.totalConfigs, this.totalHitSubTaskTags, str3, z19, Long.valueOf(currentTimeMillis));
                request.U(Boolean.valueOf(z26));
                request.p0(Long.valueOf(SystemClock.elapsedRealtime()));
                if (z26) {
                    str4 = "";
                } else {
                    str4 = "decode_fail";
                    str5 = "21";
                }
                str = str4;
            }
        } else {
            dm5.T(request, new ArrayList(), new ArrayList(), new ArrayList(), Long.valueOf(currentTimeMillis));
            if (response == null || (str = response.optString("msg")) == null) {
                str = "";
            }
            if (i16 > 0) {
                str5 = "10";
            }
            m listener = request.getListener();
            if (listener != null) {
                listener.onFail(str);
            }
        }
        return new Triple<>(Boolean.valueOf(z26), str5, str);
    }

    private final void m(JSONObject systemBizData) {
        q subSystemRespListener;
        if (systemBizData != null && (subSystemRespListener = this.setting.getSubSystemRespListener()) != null) {
            subSystemRespListener.a(systemBizData);
        }
    }

    private final JSONObject n(JSONObject response, Key aesKey) {
        int optInt = response.optInt("ret_code", -1);
        String optString = response.optString("ret_msg");
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "decryptRespData code = " + optInt + ", msg = " + optString, this.setting.getEnableDetailLog());
        }
        if (optInt == BaseProto$Code.SUCCESS.getValue() && aesKey != null) {
            byte[] decode = Base64.decode(response.optString("cipher_text"), 2);
            Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(cipherText, Base64.NO_WRAP)");
            byte[] a16 = com.tencent.rdelivery.util.b.a(decode, aesKey.getEncoded());
            Intrinsics.checkExpressionValueIsNotNull(a16, "CryptoUtil.aesDecrypt(de\u2026dRspInfo, aesKey.encoded)");
            String A = A(a16);
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess decrypt, realRespStr = " + A, this.setting.getEnableDetailLog());
            }
            return new JSONObject(A);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(DataManager dm5, String tmpServerContext) {
        Object m476constructorimpl;
        Map<String, String> mapOf;
        Map<String, String> emptyMap;
        com.tencent.rdelivery.util.c logger;
        if (dm5.k(this.request.getUserId(), "SendRequestTask")) {
            m listener = this.request.getListener();
            if (listener != null) {
                listener.onFail("userid_changed");
            }
            this.taskResultListener.a(false, this.request, "userid_changed");
            return;
        }
        if (dm5.j(this.request.getLogicEnvironment(), "SendRequestTask")) {
            m listener2 = this.request.getListener();
            if (listener2 != null) {
                listener2.onFail(XWalkReaderBasePlugin.PARAM_KEY_ENV_CHANGED);
            }
            this.taskResultListener.a(false, this.request, XWalkReaderBasePlugin.PARAM_KEY_ENV_CHANGED);
            return;
        }
        r(dm5, tmpServerContext);
        String str = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            str = this.request.j(this.setting.getEnableEncrypt(), this.setting.getLogger(), this.setting.getEnableDetailLog(), this.setting.getRdInstanceIdentifier());
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        String str2 = str;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null && (logger = this.setting.getLogger()) != null) {
            logger.d(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "getFinalRequestString err", m479exceptionOrNullimpl);
        }
        this.request.j0(str2.length() * 2);
        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
        if (logger2 != null) {
            logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "SendRequestTask payload = " + str2, this.setting.getEnableDetailLog());
        }
        IRNetwork iRNetwork = this.netInterface;
        IRNetwork.HttpMethod httpMethod = IRNetwork.HttpMethod.POST;
        String g16 = RDeliveryRequest.INSTANCE.g(this.setting);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("content-type", "application/json"));
        emptyMap = MapsKt__MapsKt.emptyMap();
        iRNetwork.requestWithMethod(httpMethod, g16, mapOf, emptyMap, str2, new b(dm5));
    }

    static /* synthetic */ void p(SendNetRequestTask sendNetRequestTask, DataManager dataManager, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        sendNetRequestTask.o(dataManager, str);
    }

    private final void q(DataManager dm5) {
        s(this, dm5, null, 2, null);
        this.request.c0(new c(dm5));
        h.f364359c.a(this.request, this.netInterface, this.setting);
    }

    private final void r(DataManager dm5, String tmpServerContext) {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "fillArgumentForRequest tmpServerContext = " + tmpServerContext, this.setting.getEnableDetailLog());
        }
        this.request.m0(SystemClock.elapsedRealtime());
        this.request.S(dm5.getServerContext());
        if (this.request.getPullType() == BaseProto$PullType.ALL || this.setting.X()) {
            if (this.setting.V()) {
                if (Intrinsics.areEqual(this.request.getIsInitRequest(), Boolean.TRUE)) {
                    this.request.u0(dm5.A());
                }
            } else {
                this.request.v0(dm5.A());
            }
        }
        if (tmpServerContext != null) {
            this.request.S(tmpServerContext);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.request.r0(this.request.a(this.setting.getCom.heytap.mcssdk.a.a.l java.lang.String(), this.setting.getRdInstanceIdentifier(), this.setting.getLogger(), this.setting.getEnableDetailLog()));
        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
        if (logger2 != null) {
            logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "fillArgumentForRequest generateSign cost = " + (System.currentTimeMillis() - currentTimeMillis) + ", request.taskChecksum = " + this.request.getTaskChecksum(), this.setting.getEnableDetailLog());
        }
    }

    static /* synthetic */ void s(SendNetRequestTask sendNetRequestTask, DataManager dataManager, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        sendNetRequestTask.r(dataManager, str);
    }

    private final List<RDeliveryData> t(List<RDeliveryData> remainedDatas, DataManager dm5) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = remainedDatas.iterator();
        while (it.hasNext()) {
            RDeliveryData B = dm5.B(((RDeliveryData) it.next()).getKey());
            if (B != null) {
                arrayList.add(B);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(RDeliveryRequest request, IRNetwork.ResultInfo result) {
        String str;
        String str2;
        request.q0(SystemClock.elapsedRealtime());
        if (!result.isHttpError()) {
            str = "";
        } else {
            str = "2";
        }
        if (result.isOtherError()) {
            str = "3";
        }
        String str3 = str;
        m listener = request.getListener();
        if (listener != null) {
            String errorMessage = result.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "";
            }
            listener.onFail(errorMessage);
        }
        com.tencent.rdelivery.report.c cVar = com.tencent.rdelivery.report.c.f364376c;
        String valueOf = String.valueOf(result.getErrorCode());
        String errorMessage2 = result.getErrorMessage();
        if (errorMessage2 == null) {
            str2 = "";
        } else {
            str2 = errorMessage2;
        }
        cVar.k(request, false, str3, valueOf, str2, this.setting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final boolean y(RDeliveryRequest request, String result, DataManager dm5) {
        String str;
        String valueOf;
        Integer num;
        String str2;
        String valueOf2;
        Integer num2;
        String str3;
        String valueOf3;
        JSONObject jSONObject;
        JSONObject n3;
        String str4;
        request.q0(SystemClock.elapsedRealtime());
        if (f(request)) {
            m listener = request.getListener();
            if (listener != null) {
                listener.onFail(XWalkReaderBasePlugin.PARAM_KEY_ENV_CHANGED);
            }
            com.tencent.rdelivery.report.c.l(com.tencent.rdelivery.report.c.f364376c, request, false, "30", null, null, this.setting, 24, null);
            return false;
        }
        if (g(request)) {
            m listener2 = request.getListener();
            if (listener2 != null) {
                listener2.onFail("userid_changed");
            }
            com.tencent.rdelivery.report.c.l(com.tencent.rdelivery.report.c.f364376c, request, false, "31", null, null, this.setting, 24, null);
            return false;
        }
        if (result == null) {
            m listener3 = request.getListener();
            if (listener3 != null) {
                listener3.onFail("empty_result");
            }
            com.tencent.rdelivery.report.c.l(com.tencent.rdelivery.report.c.f364376c, request, false, "21", null, null, this.setting, 24, null);
            return false;
        }
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != 0) {
            num = "handleSuccess result = " + result;
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), num, this.setting.getEnableDetailLog());
        }
        Integer num3 = null;
        try {
            try {
                if (this.setting.getEnableEncrypt()) {
                    try {
                        jSONObject = new JSONObject(result);
                        num2 = Integer.valueOf(jSONObject.optInt("ret_code", -1));
                    } catch (Exception e16) {
                        e = e16;
                        num2 = null;
                    } catch (Throwable unused) {
                        num = 0;
                        com.tencent.rdelivery.report.c cVar = com.tencent.rdelivery.report.c.f364376c;
                        if (num == 0 || (valueOf2 = String.valueOf(num.intValue())) == null) {
                            str2 = "";
                        } else {
                            str2 = valueOf2;
                        }
                        cVar.k(request, false, "22", str2, "decrypt_fail", this.setting);
                        m listener4 = request.getListener();
                        if (listener4 != null) {
                            listener4.onFail("decrypt_fail");
                        }
                        return false;
                    }
                    try {
                        n3 = n(jSONObject, request.getAesKey());
                        if (n3 == null) {
                            com.tencent.rdelivery.report.c cVar2 = com.tencent.rdelivery.report.c.f364376c;
                            String valueOf4 = String.valueOf(num2.intValue());
                            if (valueOf4 == null) {
                                str4 = "";
                            } else {
                                str4 = valueOf4;
                            }
                            cVar2.k(request, false, "22", str4, "decrypt_fail", this.setting);
                            m listener5 = request.getListener();
                            if (listener5 != null) {
                                listener5.onFail("decrypt_fail");
                            }
                            return false;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
                        if (logger2 != null) {
                            logger2.d(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess fail to decrypt response", e);
                        }
                        com.tencent.rdelivery.report.c cVar3 = com.tencent.rdelivery.report.c.f364376c;
                        if (num2 == null || (valueOf3 = String.valueOf(num2.intValue())) == null) {
                            str3 = "";
                        } else {
                            str3 = valueOf3;
                        }
                        cVar3.k(request, false, "22", str3, "decrypt_fail", this.setting);
                        m listener6 = request.getListener();
                        if (listener6 != null) {
                            listener6.onFail("decrypt_fail");
                        }
                        return false;
                    }
                } else {
                    n3 = new JSONObject(result);
                }
                Integer valueOf5 = Integer.valueOf(n3.optInt("code", -1));
                Triple<Boolean, String, String> l3 = l(n3, request, dm5);
                boolean booleanValue = l3.getFirst().booleanValue();
                com.tencent.rdelivery.report.c.f364376c.k(request, booleanValue, l3.getSecond(), String.valueOf(valueOf5.intValue()), l3.getThird(), this.setting);
                return booleanValue;
            } catch (Throwable unused2) {
            }
        } catch (Exception e18) {
            com.tencent.rdelivery.util.c logger3 = this.setting.getLogger();
            if (logger3 != null) {
                logger3.d(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess fail to decode response", e18);
            }
            com.tencent.rdelivery.report.c cVar4 = com.tencent.rdelivery.report.c.f364376c;
            if (0 == 0 || (valueOf = String.valueOf(num3.intValue())) == null) {
                str = "";
            } else {
                str = valueOf;
            }
            cVar4.k(request, false, "21", str, "decode_fail", this.setting);
            m listener7 = request.getListener();
            if (listener7 == null) {
                return false;
            }
            listener7.onFail("decode_fail");
            return false;
        }
    }

    private final void z(JSONArray configs, JSONArray hitSubTaskTags) {
        if (!this.setting.getEnableDetailLog()) {
            return;
        }
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext segmentRespServerContext = " + this.segmentRespServerContext, false, 4, null);
        }
        com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
        if (logger2 != null) {
            com.tencent.rdelivery.util.c.b(logger2, com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext curConfig = " + configs, false, 4, null);
        }
        com.tencent.rdelivery.util.c logger3 = this.setting.getLogger();
        if (logger3 != null) {
            com.tencent.rdelivery.util.c.b(logger3, com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext totalConfigs = " + this.totalConfigs, false, 4, null);
        }
        com.tencent.rdelivery.util.c logger4 = this.setting.getLogger();
        if (logger4 != null) {
            com.tencent.rdelivery.util.c.b(logger4, com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext hitSubTaskTags = " + hitSubTaskTags, false, 4, null);
        }
        com.tencent.rdelivery.util.c logger5 = this.setting.getLogger();
        if (logger5 != null) {
            com.tencent.rdelivery.util.c.b(logger5, com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", this.setting.getRdInstanceIdentifier()), "handleSuccess hasNext totalHitSubTaskTags = " + this.totalHitSubTaskTags, false, 4, null);
        }
    }

    @NotNull
    public final String A(@NotNull byte[] content) {
        BufferedReader bufferedReader;
        Intrinsics.checkParameterIsNotNull(content, "content");
        Reader inputStreamReader = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(content)), Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) inputStreamReader;
        } else {
            bufferedReader = new BufferedReader(inputStreamReader, 8192);
        }
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readText;
        } finally {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        DataManager ref = getRef();
        if (ref != null) {
            if (this.request.getMergeReqId() != null) {
                q(ref);
                return;
            } else {
                p(this, ref, null, 2, null);
                return;
            }
        }
        m listener = this.request.getListener();
        if (listener != null) {
            listener.onFail("null_ref");
        }
        Long mergeReqId = this.request.getMergeReqId();
        if (mergeReqId != null) {
            h.f364359c.c(mergeReqId.longValue(), this.setting);
        }
        this.taskResultListener.a(false, this.request, "null_ref");
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final RDeliveryRequest getRequest() {
        return this.request;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final e.b getTaskResultListener() {
        return this.taskResultListener;
    }
}
