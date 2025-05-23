package com.tencent.guild.api.msg.service;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOSession;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import st1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020\u000fH\u0017J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0017J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020\u0015H\u0017J>\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u001e\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0019j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u001aH\u0007J\u001e\u0010 \u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020!H\u0016J(\u0010%\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020!2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\f0#J\u001c\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020&H\u0016J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020(H\u0016J0\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00022\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\f0#J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110-0\u0006H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0016J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110-0\u0006H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110-0\u0006H\u0007J\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00070\u00062\u0006\u0010+\u001a\u00020\u0002H\u0007J\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0006J\f\u00106\u001a\b\u0012\u0004\u0012\u0002040\u0006J\f\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0006J\f\u00109\u001a\b\u0012\u0004\u0012\u0002040\u0006J\u001e\u0010<\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0-0:0\u0006J\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u000b\u001a\u00020\u000fH\u0007\u00a8\u0006@"}, d2 = {"Lcom/tencent/guild/api/msg/service/ChannelAIOMsgService;", "Lcom/tencent/aio/msgservice/a;", "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, "", "msgId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/aio/msgservice/j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lst1/n;", "req", "", "f", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/msgservice/d;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "t", "Lcom/tencent/aio/msgservice/f;", "r", "Lcom/tencent/aio/msgservice/e;", "u", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "msgIds", ReportConstant.COSTREPORT_PREFIX, "peerUid", "", "chatType", "g", "Lcom/tencent/aio/msgservice/c;", "j", "Lkotlin/Function1;", "cb", "k", "Lcom/tencent/aio/msgservice/g;", "v", "Lcom/tencent/aio/msgservice/b;", "i", "cnt", "aioSession", "p", "", "y", "E", HippyTKDListViewAdapter.X, "w", "Ler0/a;", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "D", "B", "Lcom/tencent/qqnt/msg/data/b;", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "", "Lfr0/a;", "H", DomainData.DOMAIN_NAME, "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ChannelAIOMsgService extends com.tencent.aio.msgservice.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChannelAIOMsgService f112613a = new ChannelAIOMsgService();

    ChannelAIOMsgService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Ref.ObjectRef sendMsgsCB, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(new com.tencent.aio.msgservice.j(z16, i3, str, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Ref.ObjectRef sendMsgsCB, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(new com.tencent.aio.msgservice.j(z16, i3, str, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 cb5, int i3, String str, ArrayList msgList, HashMap hashMap) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        l lVar = l.f112634a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        cb5.invoke(new com.tencent.aio.msgservice.h(z16, i3, str, lVar.g(msgList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, int i16, Function1 cb5, int i17, String str, ArrayList msgList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        TraceUtils.j("loadFirstPageMsg", i3);
        g12.b.f401087a.a(GuildHistogramScene.GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST, String.valueOf(i16));
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        l lVar = l.f112634a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        cb5.invoke(new com.tencent.aio.msgservice.h(z16, i17, str, lVar.g(msgList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, int i16, Function1 cb5, int i17, String str, ArrayList msgList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        TraceUtils.j("loadMsgFromDb", i3);
        g12.b.f401087a.a(GuildHistogramScene.GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST, String.valueOf(i16));
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        l lVar = l.f112634a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        cb5.invoke(new com.tencent.aio.msgservice.h(z16, i17, str, lVar.g(msgList)));
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> B() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadCompleteFlow();
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> C() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadProgressFlow();
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> D() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaUploadCompleteFlow();
    }

    @NotNull
    public Flow<com.tencent.aio.data.msglist.a> E() {
        return FlowKt.flow(new ChannelAIOMsgService$sendMsgNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow(), null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<String>> F(@NotNull n req) {
        Intrinsics.checkNotNullParameter(req, "req");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        QLog.i("GuildAIOMsgService", 1, "sendMsg " + req.getPeer() + " " + req.a().size());
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(req.getPeer(), req.a(), new IOperateCallback() { // from class: com.tencent.guild.api.msg.service.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                ChannelAIOMsgService.G(Ref.ObjectRef.this, i3, str);
            }
        });
        return FlowKt.callbackFlow(new ChannelAIOMsgService$sendMsgs$2(objectRef, null));
    }

    @NotNull
    public final Flow<Map<Integer, List<fr0.a>>> H() {
        return FlowKt.flow(new ChannelAIOMsgService$unreadCntUpdateFlow$$inlined$transform$1(((IGuildMsgService) QRoute.api(IGuildMsgService.class)).registerUnreadCntInfoUpdateFlow(), null));
    }

    public final void f(@NotNull n req) {
        Intrinsics.checkNotNullParameter(req, "req");
        ((IMsgService) QRoute.api(IMsgService.class)).addSendMsg(req.getPeer(), req.a());
    }

    public final void g(long msgId, @NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        if (iMsgService != null) {
            iMsgService.cancelSendMsg(msgId, peerUid, chatType);
        }
    }

    @NotNull
    public final Flow<com.tencent.qqnt.msg.data.b> h() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerChannelFreqLimitInfoUpdateNotificationFlow();
    }

    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> i(@NotNull com.tencent.aio.msgservice.b req) {
        Intrinsics.checkNotNullParameter(req, "req");
        long j3 = 0;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            QLog.i("GuildAIOMsgService", 1, "getBottomPageMsgList, isGuest. channelId: " + req.a().c().j() + ", guildId: " + req.a().c().f());
            AIOSession a16 = req.a();
            com.tencent.aio.data.msglist.a b16 = req.b();
            if (b16 != null) {
                j3 = b16.getMsgSeq();
            }
            return n(new com.tencent.aio.msgservice.d(a16, j3, req.c(), false));
        }
        AIOSession a17 = req.a();
        com.tencent.aio.data.msglist.a b17 = req.b();
        if (b17 != null) {
            j3 = b17.getMsgId();
        }
        return r(new com.tencent.aio.msgservice.f(a17, j3, req.c(), false));
    }

    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> j(@NotNull com.tencent.aio.msgservice.c req) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            QLog.i("GuildAIOMsgService", 1, "getFirstPageMsgList, isGuest. channelId: " + req.a().c().j() + ", guildId: " + req.a().c().f());
            return n(new com.tencent.aio.msgservice.d(req.a(), 0L, req.b(), true));
        }
        return r(new com.tencent.aio.msgservice.f(req.a(), 0L, req.b(), true));
    }

    public final void k(@NotNull com.tencent.aio.msgservice.c req, @NotNull final Function1<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Contact c16 = l.f112634a.c(req.a());
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            QLog.i("GuildAIOMsgService", 1, "getFirstPageMsgList, isGuest. channelId: " + req.a().c().j() + ", guildId: " + req.a().c().f());
            com.tencent.aio.msgservice.d dVar = new com.tencent.aio.msgservice.d(req.a(), 0L, req.b(), true);
            ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(c16, dVar.c(), dVar.b(), dVar.d(), new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guild.api.msg.service.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                    ChannelAIOMsgService.l(Function1.this, i3, str, arrayList, hashMap);
                }
            });
            return;
        }
        g12.b bVar = g12.b.f401087a;
        final int d16 = bVar.d();
        bVar.h(GuildHistogramScene.GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST, String.valueOf(d16));
        final int g16 = TraceUtils.g("loadFirstPageMsg");
        com.tencent.aio.msgservice.f fVar = new com.tencent.aio.msgservice.f(req.a(), 0L, req.b(), true);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(c16, fVar.c(), fVar.b(), fVar.d(), new IMsgOperateCallback() { // from class: com.tencent.guild.api.msg.service.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                ChannelAIOMsgService.m(g16, d16, cb5, i3, str, arrayList);
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> n(@NotNull com.tencent.aio.msgservice.d req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getGuestMsgByRange$1(req, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<er0.a>> o(@NotNull AIOSession aioSession) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getGuildNavigationInfo$1(aioSession, null));
    }

    public final void p(int cnt, @NotNull AIOSession aioSession, @NotNull final Function1<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        g12.b bVar = g12.b.f401087a;
        final int c16 = bVar.c();
        bVar.h(GuildHistogramScene.GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST, String.valueOf(c16));
        final int g16 = TraceUtils.g("loadMsgFromDb");
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(l.f112634a.c(aioSession), cnt, new IMsgOperateCallback() { // from class: com.tencent.guild.api.msg.service.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                ChannelAIOMsgService.q(g16, c16, cb5, i3, str, arrayList);
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> r(@NotNull com.tencent.aio.msgservice.f req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getMsgs$1(req, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> s(@Nullable Contact peer, @Nullable ArrayList<Long> msgIds) {
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getMsgsByMsgId$1(peer, msgIds, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> t(@NotNull com.tencent.aio.msgservice.d req) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            return n(new com.tencent.aio.msgservice.d(req.a(), req.c(), req.b(), req.d()));
        }
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getMsgsBySeqAndCount$1(req, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> u(@NotNull com.tencent.aio.msgservice.e req) {
        long j3;
        long j16;
        long j17;
        boolean z16;
        Intrinsics.checkNotNullParameter(req, "req");
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            QLog.i("GuildAIOMsgService", 1, "getMsgsBySeqRange, isGuest. channelId: " + req.a().c().j() + ", guildId: " + req.a().c().f());
            Long b16 = req.b();
            if (b16 != null) {
                j3 = b16.longValue();
            } else {
                j3 = 0;
            }
            Long c16 = req.c();
            if (c16 != null) {
                j16 = c16.longValue();
            } else {
                j16 = 0;
            }
            long max = Math.max(j16 - j3, 1L);
            long max2 = Math.max(j3 - 1, 0L);
            if (max2 <= 0) {
                z16 = true;
                j17 = max;
            } else {
                j17 = max2;
                z16 = false;
            }
            return n(new com.tencent.aio.msgservice.d(req.a(), j17, (int) max, z16));
        }
        return FlowKt.callbackFlow(new ChannelAIOMsgService$getMsgsBySeqRange$1(req, null));
    }

    @NotNull
    public Flow<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> v(@NotNull com.tencent.aio.msgservice.g req) {
        Intrinsics.checkNotNullParameter(req, "req");
        long j3 = 0;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(req.a().c().j(), req.a().c().f())) {
            QLog.i("GuildAIOMsgService", 1, "getTopPageMsgList, isGuest. channelId: " + req.a().c().j() + ", guildId: " + req.a().c().f());
            AIOSession a16 = req.a();
            com.tencent.aio.data.msglist.a c16 = req.c();
            if (c16 != null) {
                j3 = c16.getMsgSeq();
            }
            return n(new com.tencent.aio.msgservice.d(a16, j3, req.b(), true));
        }
        AIOSession a17 = req.a();
        com.tencent.aio.data.msglist.a c17 = req.c();
        if (c17 != null) {
            j3 = c17.getMsgId();
        }
        return r(new com.tencent.aio.msgservice.f(a17, j3, req.b(), true));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<List<com.tencent.aio.data.msglist.a>> w() {
        return FlowKt.flow(new ChannelAIOMsgService$msgInfoListAddNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerMsgInfoListAddNotificationFlow(), null));
    }

    @NotNull
    public Flow<List<com.tencent.aio.data.msglist.a>> x() {
        return FlowKt.flow(new ChannelAIOMsgService$msgStatusUpdateNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), null));
    }

    @NotNull
    public Flow<List<com.tencent.aio.data.msglist.a>> y() {
        return FlowKt.flow(new ChannelAIOMsgService$receiveMsgNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<String>> z(@NotNull AIOSession session, long msgId) {
        Intrinsics.checkNotNullParameter(session, "session");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(l.f112634a.c(session), msgId, new IOperateCallback() { // from class: com.tencent.guild.api.msg.service.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                ChannelAIOMsgService.A(Ref.ObjectRef.this, i3, str);
            }
        });
        return FlowKt.callbackFlow(new ChannelAIOMsgService$resendMsg$2(objectRef, null));
    }
}
