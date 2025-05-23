package com.tencent.mobileqq.qqlive.push;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import tl.h;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001WBU\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u000b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\bT\u0010UJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010 R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b$\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001cR\u0016\u00108\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001cR\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010>R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010AR0\u0010K\u001a\u001e\u0012\u0004\u0012\u00020F\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060Gj\b\u0012\u0004\u0012\u00020\u0006`H0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/PullHandler;", "Lkotlinx/coroutines/CoroutineScope;", "Ljp4/c;", "rsp", "", h.F, "Lfp4/c;", "msg", "Ljava/util/LinkedList;", "", "cacheList", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "action", "j", "i", "key", "value", "Lorg/json/JSONObject;", "l", "Ljp4/a;", "k", DomainData.DOMAIN_NAME, "d", "Ljava/lang/String;", "appId", "", "e", "J", "roomId", "f", "openTime", "Lkotlinx/coroutines/channels/Channel;", "constChannel", "nonConstChannel", "Lcom/tencent/mobileqq/qqlive/push/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "smoothChannel", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "getSmoothConfig", "()Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "(Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;)V", "smoothConfig", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "E", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "", UserInfo.SEX_FEMALE, "Z", "isStarted", "G", "msgRspSeq", "H", "pullRequestInterval", "", "I", "[B", "cookie", "Lorg/json/JSONArray;", "Lorg/json/JSONArray;", "jsonArray", "K", "Ljava/util/LinkedList;", "constCacheList", "L", "nonConstCacheList", "", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "M", "Ljava/util/Map;", "smoothMsgsMap", "Lcom/tencent/mobileqq/qqlive/push/c;", "N", "Lcom/tencent/mobileqq/qqlive/push/c;", "msgPrinter", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/String;JJLkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;)V", "P", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PullHandler implements CoroutineScope {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private final Map<Integer, ArrayList<fp4.c>> smoothMsgsMap;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final c msgPrinter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long openTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<fp4.c> constChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<fp4.c> nonConstChannel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<g> smoothChannel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/PullHandler$a;", "", "", "LOG_TAG", "Ljava/lang/String;", "", "MAX_CACHE_MESSAGE_NUM", "I", "", "MIN_PULL_REQUEST_INTERVAL", "J", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.push.PullHandler$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        static IPatchRedirector $redirector_;

        public b(CoroutineExceptionHandler.Companion companion) {
            super(companion);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) companion);
            }
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) exception);
            } else {
                AegisLogger.INSTANCE.e("Push|PullHandler", "jobException", "error, ", exception);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PullHandler(@NotNull String appId, long j3, long j16, @NotNull Channel<fp4.c> constChannel, @NotNull Channel<fp4.c> nonConstChannel, @NotNull Channel<g> smoothChannel, @Nullable MessagePushConfig messagePushConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(constChannel, "constChannel");
        Intrinsics.checkNotNullParameter(nonConstChannel, "nonConstChannel");
        Intrinsics.checkNotNullParameter(smoothChannel, "smoothChannel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, Long.valueOf(j3), Long.valueOf(j16), constChannel, nonConstChannel, smoothChannel, messagePushConfig);
            return;
        }
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
        this.msgPrinter = new c();
        com.tencent.mobileqq.qqlive.config.a a16 = com.tencent.mobileqq.qqlive.config.a.INSTANCE.a(appId);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(l(AudienceReportConst.CLIENT_TYPE, String.valueOf(a16.a().e())));
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
    public final void h(jp4.c rsp) {
        long coerceAtLeast;
        List filterNotNull;
        List filterNotNull2;
        Integer num;
        if (rsp == null) {
            AegisLogger.INSTANCE.w("Push|PullHandler", "deliverNewMsgs", "invalid rsp");
            return;
        }
        long j3 = rsp.f410800a;
        long j16 = this.roomId;
        if (j3 == j16) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rsp.f410803d, 500L);
            this.pullRequestInterval = coerceAtLeast;
            long j17 = rsp.f410806g;
            long j18 = this.msgRspSeq;
            if (j17 > j18) {
                this.msgRspSeq = j17;
                this.cookie = rsp.f410804e;
            } else {
                AegisLogger.INSTANCE.w("Push|PullHandler", "deliverNewMsgs", "error msg seq, rsp.msgReqRspNum=" + j17 + ", msgRspSeq=" + j18);
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                fp4.c[] cVarArr = rsp.f410802c;
                Integer num2 = null;
                if (cVarArr != null) {
                    num = Integer.valueOf(cVarArr.length);
                } else {
                    num = null;
                }
                companion.d("Push|PullHandler", "deliverNewMsgs", "nonConstMsg size=" + num);
                fp4.c[] cVarArr2 = rsp.f410801b;
                if (cVarArr2 != null) {
                    num2 = Integer.valueOf(cVarArr2.length);
                }
                companion.d("Push|PullHandler", "deliverNewMsgs", "constMsg size=" + num2);
            }
            fp4.c[] cVarArr3 = rsp.f410802c;
            if (cVarArr3 != null && filterNotNull2 != null) {
                Iterator it = filterNotNull2.iterator();
                while (it.hasNext()) {
                    j((fp4.c) it.next(), this.nonConstCacheList, this.nonConstChannel, "deliverNonConstSpeedMsgs");
                }
            }
            fp4.c[] cVarArr4 = rsp.f410801b;
            if (cVarArr4 != null && filterNotNull != null) {
                Iterator it5 = filterNotNull.iterator();
                while (it5.hasNext()) {
                    j((fp4.c) it5.next(), this.constCacheList, this.constChannel, "deliverConstSpeedMsgs");
                }
            }
            i();
            this.msgPrinter.d(rsp);
            return;
        }
        AegisLogger.INSTANCE.w("Push|PullHandler", "deliverNewMsgs", "not the same room, rsp.roomId=" + j3 + ", roomId=" + j16);
    }

    private final void i() {
        for (Map.Entry<Integer, ArrayList<fp4.c>> entry : this.smoothMsgsMap.entrySet()) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("Push|PullHandler", "deliverSmoothMsgs", "cmd=" + entry.getKey() + ", size=" + entry.getValue().size());
            }
            if (entry.getValue().size() > 0) {
                long size = this.pullRequestInterval / entry.getValue().size();
                int i3 = 0;
                for (Object obj : entry.getValue()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    fp4.c cVar = (fp4.c) obj;
                    long j3 = i3 * size;
                    AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                    if (companion2.isDevelopLevel()) {
                        companion2.d("Push|PullHandler", "deliverSmoothMsgs", "offer smooth msg, " + com.tencent.mobileqq.qqlive.push.b.a(cVar) + ", delay=" + j3);
                    }
                    this.smoothChannel.mo2003trySendJP2dKIU(new g(j3, cVar));
                    i3 = i16;
                }
                entry.getValue().clear();
            }
        }
    }

    private final void j(fp4.c msg2, LinkedList<String> cacheList, Channel<fp4.c> channel, String action) {
        ArrayList<Integer> messageType;
        if (cacheList.contains(e.a(msg2))) {
            AegisLogger.INSTANCE.d("Push|PullHandler", action, "ignore duplicate msg, " + com.tencent.mobileqq.qqlive.push.b.a(msg2));
            return;
        }
        cacheList.add(e.a(msg2));
        if (cacheList.size() > 200) {
            CollectionsKt__MutableCollectionsKt.removeFirstOrNull(cacheList);
        }
        MessagePushConfig messagePushConfig = this.smoothConfig;
        boolean z16 = false;
        if (messagePushConfig != null && (messageType = messagePushConfig.getMessageType()) != null && messageType.contains(Integer.valueOf(msg2.f400284b))) {
            z16 = true;
        }
        if (z16) {
            Map<Integer, ArrayList<fp4.c>> map = this.smoothMsgsMap;
            Integer valueOf = Integer.valueOf(msg2.f400284b);
            ArrayList<fp4.c> arrayList = map.get(valueOf);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(valueOf, arrayList);
            }
            arrayList.add(msg2);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("Push|PullHandler", action, "offer msg, " + com.tencent.mobileqq.qqlive.push.b.a(msg2));
        }
        channel.mo2003trySendJP2dKIU(msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jp4.a k() {
        jp4.a aVar = new jp4.a();
        try {
            JSONArray jSONArray = this.jsonArray;
            if (jSONArray != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("gap", this.pullRequestInterval);
                jSONObject.put("infos", jSONArray);
                HashMap hashMap = new HashMap();
                aVar.f410793a = hashMap;
                Intrinsics.checkNotNullExpressionValue(hashMap, "extInfo.transInfo");
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonItem.toString()");
                byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                hashMap.put("heart_beat", bytes);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Push|PullHandler", "getExtInfo", "error, ", e16);
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
            AegisLogger.INSTANCE.e("Push|PullHandler", "jsonItem", "error, ", e16);
            return new JSONObject();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.D.getCoroutineContext();
    }

    public final void m(@Nullable MessagePushConfig messagePushConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messagePushConfig);
        } else {
            this.smoothConfig = messagePushConfig;
        }
    }

    public final void n() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (!this.isStarted) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PullHandler$start$2(this, null), 2, null);
                launch$default.invokeOnCompletion(PullHandler$start$3$1.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("PullHandler is already started".toString());
        }
    }
}
