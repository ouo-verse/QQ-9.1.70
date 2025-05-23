package com.tencent.mobileqq.aio.msg.service;

import android.content.Context;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgsReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u00017B\u0011\u0012\b\u0010<\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b=\u0010>B\t\b\u0016\u00a2\u0006\u0004\b=\u0010?J\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u000b0\n0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0006J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\u0006J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\u0006J&\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0007J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u0016J*\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001c0\u00062\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u0018J\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001c0\u00062\u0006\u0010\u0013\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0019J\"\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001c0\u00062\u0006\u0010\u0013\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020$H\u0007J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0006J \u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010(j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`)0\u0006J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0019J4\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010+\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J*\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010+\u001a\u00020&2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0019J*\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010+\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019R\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u0001068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "", "", "cnt", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "e", "Lkotlin/Pair;", "", "b", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "r", "Lcom/tencent/aio/msgservice/d;", "req", "includeDeleteMsg", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgsReq;", "i", "Lcom/tencent/aio/msgservice/g;", "", "appId", "msgTime", "Lcom/tencent/mobileqq/aio/msg/service/p;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/msgservice/c;", "d", "Lcom/tencent/mobileqq/aio/msg/service/o;", "appid", "k", "Lcom/tencent/aio/msgservice/f;", "g", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "p", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ReportConstant.COSTREPORT_PREFIX, "peer", "time", "Lcom/tencent/mobileqq/aio/msg/service/r;", "o", "clientSeq", "j", "rootMsgId", "parentMsgId", "l", "f", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "a", "Lmqq/util/WeakReference;", "weakContext", "c", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgServiceWithContext {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> weakContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57679);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMsgServiceWithContext(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.weakContext = new WeakReference<>(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context c() {
        return this.weakContext.get();
    }

    @NotNull
    public final Flow<Pair<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>> b(int cnt, @NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Flow) iPatchRedirector.redirect((short) 4, (Object) this, cnt, (Object) aioSession);
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1(aioSession, cnt, this, null));
    }

    @NotNull
    public final Flow<p<com.tencent.aio.data.msglist.a>> d(@NotNull com.tencent.aio.msgservice.c req, long appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Flow) iPatchRedirector.redirect((short) 13, this, req, Long.valueOf(appId));
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return k(new o(req.a(), 0L, 0L, req.b(), true), appId);
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> e(int cnt, @NotNull AIOSession aioSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, (Object) this, cnt, (Object) aioSession);
        }
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getLatestDbMsgs$1(aioSession, cnt, this, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> f(@NotNull Contact peer, long clientSeq, long msgTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Flow) iPatchRedirector.redirect((short) 22, this, peer, Long.valueOf(clientSeq), Long.valueOf(msgTime));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgByClientSeqAndTime$1(peer, clientSeq, msgTime, this, null));
    }

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> g(@NotNull com.tencent.aio.msgservice.f req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Flow) iPatchRedirector.redirect((short) 15, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgs$1(req, this, null));
    }

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> h(@NotNull com.tencent.aio.msgservice.d req, boolean includeDeleteMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Flow) iPatchRedirector.redirect((short) 8, this, req, Boolean.valueOf(includeDeleteMsg));
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgsBySeqAndCount$1(req, includeDeleteMsg, this, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> i(@NotNull MsgsReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Flow) iPatchRedirector.redirect((short) 9, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgsExt$1(req, this, null));
    }

    @Deprecated(message = "9.0.30\u5f00\u59cb\u5e9f\u5f03\uff0c\u7531getMsgsExt\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "getMsgsExt", imports = {}))
    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> j(@NotNull Contact peer, long msgTime, long clientSeq, int cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Flow) iPatchRedirector.redirect((short) 20, this, peer, Long.valueOf(msgTime), Long.valueOf(clientSeq), Integer.valueOf(cnt));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1(peer, msgTime, clientSeq, cnt, this, null));
    }

    @NotNull
    public final Flow<p<com.tencent.aio.data.msglist.a>> k(@NotNull o req, long appid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Flow) iPatchRedirector.redirect((short) 14, this, req, Long.valueOf(appid));
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMsgsWithStatus$1(req, appid, this, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> l(@NotNull Contact peer, long rootMsgId, long parentMsgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Flow) iPatchRedirector.redirect((short) 21, this, peer, Long.valueOf(rootMsgId), Long.valueOf(parentMsgId));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$getMultiMsgs$1(peer, rootMsgId, parentMsgId, this, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> m(@NotNull com.tencent.aio.msgservice.g req) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Flow) iPatchRedirector.redirect((short) 11, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        AIOSession a16 = req.a();
        com.tencent.aio.data.msglist.a c16 = req.c();
        if (c16 != null) {
            j3 = c16.getMsgId();
        } else {
            j3 = 0;
        }
        return g(new com.tencent.aio.msgservice.f(a16, j3, req.b(), true));
    }

    @NotNull
    public final Flow<p<com.tencent.aio.data.msglist.a>> n(@NotNull com.tencent.aio.msgservice.g req, long appId, long msgTime) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Flow) iPatchRedirector.redirect((short) 10, this, req, Long.valueOf(appId), Long.valueOf(msgTime));
        }
        Intrinsics.checkNotNullParameter(req, "req");
        AIOSession a16 = req.a();
        com.tencent.aio.data.msglist.a c16 = req.c();
        if (c16 != null) {
            j3 = c16.getMsgId();
        } else {
            j3 = 0;
        }
        return k(new o(a16, j3, msgTime, req.b(), true), appId);
    }

    @NotNull
    public final Flow<r> o(@NotNull Contact peer, long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Flow) iPatchRedirector.redirect((short) 19, this, peer, Long.valueOf(time));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgServiceWithContext$queryFirstRoamMsg$1(peer, time, null));
    }

    @NotNull
    public final Flow<Contact> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Flow) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).receiveClearMsgRecordsFlow();
    }

    @NotNull
    public final Flow<List<com.tencent.aio.data.msglist.a>> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Flow) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return FlowKt.flowOn(FlowKt.flow(new AIOMsgServiceWithContext$receiveMsgNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), null, this)), zs.b.a(Dispatchers.INSTANCE));
    }

    @NotNull
    public final Flow<List<AIOMsgItem>> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Flow) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return FlowKt.flowOn(FlowKt.flow(new AIOMsgServiceWithContext$registerMsgStatusUpdateNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), null, this)), zs.b.a(Dispatchers.INSTANCE));
    }

    @NotNull
    public final Flow<ArrayList<Long>> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Flow) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).registerOnMsgDeleteNotificationFlow();
    }

    @NotNull
    public final Flow<com.tencent.aio.data.msglist.a> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Flow) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return FlowKt.flowOn(FlowKt.flow(new AIOMsgServiceWithContext$sendMsgNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow(), null, this)), zs.b.a(Dispatchers.INSTANCE));
    }

    public AIOMsgServiceWithContext() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
