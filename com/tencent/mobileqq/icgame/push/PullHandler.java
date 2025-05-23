package com.tencent.mobileqq.icgame.push;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rt0.a;
import tl.h;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001WBU\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u000b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\bT\u0010UJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010 R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b$\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001cR\u0016\u00108\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001cR\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010>R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010AR0\u0010K\u001a\u001e\u0012\u0004\u0012\u00020F\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060Gj\b\u0012\u0004\u0012\u00020\u0006`H0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/icgame/push/PullHandler;", "Lkotlinx/coroutines/CoroutineScope;", "Lez0/c;", "rsp", "", h.F, "Lbz0/c;", "msg", "Ljava/util/LinkedList;", "", "cacheList", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "action", "j", "i", "key", "value", "Lorg/json/JSONObject;", "l", "Lez0/a;", "k", DomainData.DOMAIN_NAME, "d", "Ljava/lang/String;", "appId", "", "e", "J", "roomId", "f", "openTime", "Lkotlinx/coroutines/channels/Channel;", "constChannel", "nonConstChannel", "Lcom/tencent/mobileqq/icgame/push/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "smoothChannel", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "getSmoothConfig", "()Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "(Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;)V", "smoothConfig", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "E", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "", UserInfo.SEX_FEMALE, "Z", "isStarted", "G", "msgRspSeq", "H", "pullRequestInterval", "", "I", "[B", "cookie", "Lorg/json/JSONArray;", "Lorg/json/JSONArray;", "jsonArray", "K", "Ljava/util/LinkedList;", "constCacheList", "L", "nonConstCacheList", "", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "M", "Ljava/util/Map;", "smoothMsgsMap", "Lcom/tencent/mobileqq/icgame/push/b;", "N", "Lcom/tencent/mobileqq/icgame/push/b;", "msgPrinter", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/String;JJLkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;)V", "P", "a", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PullHandler implements CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MessagePushConfig smoothConfig;
    private final /* synthetic */ CoroutineScope D;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CoroutineExceptionHandler jobException;

    /* renamed from: F, reason: from kotlin metadata */
    private volatile boolean isStarted;

    /* renamed from: G, reason: from kotlin metadata */
    private long msgRspSeq;

    /* renamed from: H, reason: from kotlin metadata */
    private long pullRequestInterval;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private byte[] cookie;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private JSONArray jsonArray;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LinkedList<String> constCacheList;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LinkedList<String> nonConstCacheList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, ArrayList<bz0.c>> smoothMsgsMap;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.push.b msgPrinter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long openTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<bz0.c> constChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<bz0.c> nonConstChannel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<SmoothMsgInfo> smoothChannel;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            rt0.a.INSTANCE.i("ICGamePush|ICGamePullHandler", "jobException", "error, ", exception);
        }
    }

    public PullHandler(@NotNull String appId, long j3, long j16, @NotNull Channel<bz0.c> constChannel, @NotNull Channel<bz0.c> nonConstChannel, @NotNull Channel<SmoothMsgInfo> smoothChannel, @Nullable MessagePushConfig messagePushConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(constChannel, "constChannel");
        Intrinsics.checkNotNullParameter(nonConstChannel, "nonConstChannel");
        Intrinsics.checkNotNullParameter(smoothChannel, "smoothChannel");
        this.appId = appId;
        this.roomId = j3;
        this.openTime = j16;
        this.constChannel = constChannel;
        this.nonConstChannel = nonConstChannel;
        this.smoothChannel = smoothChannel;
        this.smoothConfig = messagePushConfig;
        this.D = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(LiveCoroutineScopes.f273421a.a()));
        this.jobException = new b(CoroutineExceptionHandler.INSTANCE);
        this.pullRequestInterval = 1000L;
        this.constCacheList = new LinkedList<>();
        this.nonConstCacheList = new LinkedList<>();
        this.smoothMsgsMap = new LinkedHashMap();
        this.msgPrinter = new com.tencent.mobileqq.icgame.push.b();
        d32.a a16 = d32.a.INSTANCE.a(appId);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(l(AudienceReportConst.CLIENT_TYPE, String.valueOf(a16.a().getClientType())));
            jSONArray.mo162put(l("uid", account));
            jSONArray.mo162put(l(AudienceReportConst.ROOM_ID, String.valueOf(j3)));
            jSONArray.mo162put(l("enterts", String.valueOf(j16)));
            this.jsonArray = jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bf, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ez0.c rsp) {
        long coerceAtLeast;
        List filterNotNull;
        List filterNotNull2;
        Integer num;
        if (rsp == null) {
            rt0.a.INSTANCE.q("ICGamePush|ICGamePullHandler", "deliverNewMsgs", "invalid rsp");
            return;
        }
        long j3 = rsp.f397456a;
        long j16 = this.roomId;
        if (j3 == j16) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rsp.f397459d, 500L);
            this.pullRequestInterval = coerceAtLeast;
            long j17 = rsp.f397462g;
            long j18 = this.msgRspSeq;
            if (j17 > j18) {
                this.msgRspSeq = j17;
                this.cookie = rsp.f397460e;
            } else {
                rt0.a.INSTANCE.q("ICGamePush|ICGamePullHandler", "deliverNewMsgs", "error msg seq, rsp.msgReqRspNum=" + j17 + ", msgRspSeq=" + j18);
            }
            a.Companion companion = rt0.a.INSTANCE;
            if (companion.m()) {
                bz0.c[] cVarArr = rsp.f397458c;
                Integer num2 = null;
                if (cVarArr != null) {
                    num = Integer.valueOf(cVarArr.length);
                } else {
                    num = null;
                }
                companion.g("ICGamePush|ICGamePullHandler", "deliverNewMsgs", "nonConstMsg size=" + num);
                bz0.c[] cVarArr2 = rsp.f397457b;
                if (cVarArr2 != null) {
                    num2 = Integer.valueOf(cVarArr2.length);
                }
                companion.g("ICGamePush|ICGamePullHandler", "deliverNewMsgs", "constMsg size=" + num2);
            }
            bz0.c[] cVarArr3 = rsp.f397458c;
            if (cVarArr3 != null && filterNotNull2 != null) {
                Iterator it = filterNotNull2.iterator();
                while (it.hasNext()) {
                    j((bz0.c) it.next(), this.nonConstCacheList, this.nonConstChannel, "deliverNonConstSpeedMsgs");
                }
            }
            bz0.c[] cVarArr4 = rsp.f397457b;
            if (cVarArr4 != null && filterNotNull != null) {
                Iterator it5 = filterNotNull.iterator();
                while (it5.hasNext()) {
                    j((bz0.c) it5.next(), this.constCacheList, this.constChannel, "deliverConstSpeedMsgs");
                }
            }
            this.msgPrinter.b(rsp);
            return;
        }
        rt0.a.INSTANCE.q("ICGamePush|ICGamePullHandler", "deliverNewMsgs", "not the same room, rsp.roomId=" + j3 + ", roomId=" + j16);
    }

    private final void i() {
        for (Map.Entry<Integer, ArrayList<bz0.c>> entry : this.smoothMsgsMap.entrySet()) {
            a.Companion companion = rt0.a.INSTANCE;
            if (companion.m()) {
                companion.g("ICGamePush|ICGamePullHandler", "deliverSmoothMsgs", "cmd=" + entry.getKey() + ", size=" + entry.getValue().size());
            }
            if (entry.getValue().size() > 0) {
                long size = this.pullRequestInterval / entry.getValue().size();
                int i3 = 0;
                for (Object obj : entry.getValue()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    bz0.c cVar = (bz0.c) obj;
                    long j3 = i3 * size;
                    a.Companion companion2 = rt0.a.INSTANCE;
                    if (companion2.m()) {
                        companion2.g("ICGamePush|ICGamePullHandler", "deliverSmoothMsgs", "offer smooth msg, " + a.a(cVar) + ", delay=" + j3);
                    }
                    this.smoothChannel.mo2003trySendJP2dKIU(new SmoothMsgInfo(j3, cVar));
                    i3 = i16;
                }
                entry.getValue().clear();
            }
        }
    }

    private final void j(bz0.c msg2, LinkedList<String> cacheList, Channel<bz0.c> channel, String action) {
        ArrayList<Integer> messageType;
        if (cacheList.contains(d.a(msg2))) {
            rt0.a.INSTANCE.g("ICGamePush|ICGamePullHandler", action, "ignore duplicate msg, " + a.a(msg2));
            return;
        }
        cacheList.add(d.a(msg2));
        if (cacheList.size() > 200) {
            CollectionsKt__MutableCollectionsKt.removeFirstOrNull(cacheList);
        }
        MessagePushConfig messagePushConfig = this.smoothConfig;
        boolean z16 = false;
        if (messagePushConfig != null && (messageType = messagePushConfig.getMessageType()) != null && messageType.contains(Integer.valueOf(msg2.f29441b))) {
            z16 = true;
        }
        if (z16) {
            Map<Integer, ArrayList<bz0.c>> map = this.smoothMsgsMap;
            Integer valueOf = Integer.valueOf(msg2.f29441b);
            ArrayList<bz0.c> arrayList = map.get(valueOf);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(valueOf, arrayList);
            }
            arrayList.add(msg2);
        } else {
            a.Companion companion = rt0.a.INSTANCE;
            if (companion.m()) {
                companion.g("ICGamePush|ICGamePullHandler", action, "offer msg, " + a.a(msg2));
            }
            channel.mo2003trySendJP2dKIU(msg2);
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ez0.a k() {
        ez0.a aVar = new ez0.a();
        try {
            JSONArray jSONArray = this.jsonArray;
            if (jSONArray != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("gap", this.pullRequestInterval);
                jSONObject.put("infos", jSONArray);
                HashMap hashMap = new HashMap();
                aVar.f397449a = hashMap;
                Intrinsics.checkNotNullExpressionValue(hashMap, "extInfo.transInfo");
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonItem.toString()");
                byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                hashMap.put("heart_beat", bytes);
            }
        } catch (Exception e16) {
            rt0.a.INSTANCE.i("ICGamePush|ICGamePullHandler", "getExtInfo", "error, ", e16);
        }
        return aVar;
    }

    private final JSONObject l(String key, String value) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", key);
            jSONObject.put("value", value);
            return jSONObject;
        } catch (JSONException e16) {
            rt0.a.INSTANCE.i("ICGamePush|ICGamePullHandler", "jsonItem", "error, ", e16);
            return new JSONObject();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.D.getCoroutineContext();
    }

    public final void m(@Nullable MessagePushConfig messagePushConfig) {
        this.smoothConfig = messagePushConfig;
    }

    public final void n() {
        Job launch$default;
        if (!this.isStarted) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PullHandler$start$2(this, null), 2, null);
            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.icgame.push.PullHandler$start$3$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    rt0.a.INSTANCE.k("ICGamePush|ICGamePullHandler", "start", "pullJob is completed");
                }
            });
            return;
        }
        throw new IllegalArgumentException("PullHandler is already started".toString());
    }
}
