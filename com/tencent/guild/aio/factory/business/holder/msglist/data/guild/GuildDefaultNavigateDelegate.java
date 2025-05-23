package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildDefaultNavigateDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", "msgSeq", "", "u", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "v", "c", tl.h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "getHost", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "setHost", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "host", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", "g", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", "getMBeforeNavigateNotifier", "()Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", HippyTKDListViewAdapter.X, "(Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;)V", "mBeforeNavigateNotifier", "<init>", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildDefaultNavigateDelegate extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v mBeforeNavigateNotifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDefaultNavigateDelegate(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, long msgSeq) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        boolean z16;
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildNavigateDelegate", 1, "handleNavigateToMsg, channelId = " + com.tencent.guild.aio.util.a.b(g16) + " msgSeq = " + msgSeq + ", succ = " + rsp.d() + " , size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            Iterator<com.tencent.aio.data.msglist.a> it = rsp.a().iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getMsgSeq() == msgSeq) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            AIOParam g17 = d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildNavigateDelegate", 1, "handleNavigateToMsg, channelId = " + b16 + " pos = " + i3 + ", msgSeq = " + msgSeq + " firstSeq = " + l3 + " lastSeq = " + l16);
            if (i3 != -1) {
                com.tencent.aio.data.msglist.a aVar3 = rsp.a().get(i3);
                Intrinsics.checkNotNull(aVar3, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                if (!v((GuildMsgItem) aVar3)) {
                    MsgList g18 = g();
                    g18.clear();
                    g18.addAll(rsp.a());
                    b bVar = b.f110545a;
                    bVar.p(this.host, IMsgListRepository.MsgListRepoOpType.LoadRangePage, g18, bVar.e("GuildNavigateDelegate", "handleNavigateToMsg"), bVar.f(msgSeq));
                    return;
                }
            }
            d().e().h(new GuildMsgListIntent.NavigateToDeletedMsgEvent());
            return;
        }
        b bVar2 = b.f110545a;
        b.o(bVar2, this.host, IMsgListRepository.MsgListRepoOpType.LoadRangePage, g(), bVar2.e("GuildNavigateDelegate", "handleNavigateToMsg"), null, 16, null);
    }

    private final boolean v(GuildMsgItem msgItem) {
        if (com.tencent.guild.aio.util.ex.f.b(msgItem)) {
            return true;
        }
        if (msgItem.isGrayTipMsg() && !com.tencent.guild.aio.util.ex.f.c(msgItem)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[LOOP:0: B:5:0x001b->B:13:0x0045, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[EDGE_INSN: B:14:0x0049->B:15:0x0049 BREAK  A[LOOP:0: B:5:0x001b->B:13:0x0045], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void w(GuildDefaultNavigateDelegate this$0, long j3) {
        int coerceAtMost;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.mBeforeNavigateNotifier;
        if (vVar != null) {
            vVar.a(j3);
        }
        MsgList g16 = this$0.g();
        Iterator<com.tencent.aio.data.msglist.a> it = g16.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.aio.data.msglist.a next = it.next();
                if (next.getMsgSeq() == j3) {
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    if (com.tencent.guild.api.data.msglist.a.b((GuildMsgItem) next)) {
                        z16 = true;
                        if (!z16) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                i3 = -1;
                break;
            }
        }
        AIOParam g17 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        QLog.i("GuildNavigateDelegate", 1, "navigateToMsg, channelId = " + com.tencent.guild.aio.util.a.b(g17) + ", found in displayList, pos =  " + i3);
        if (i3 != -1) {
            com.tencent.aio.data.msglist.a aVar = g16.get(i3);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (this$0.v((GuildMsgItem) aVar)) {
                this$0.d().e().h(new GuildMsgListIntent.NavigateToDeletedMsgEvent());
                return;
            } else {
                b bVar = b.f110545a;
                bVar.p(this$0.host, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildNavigateDelegate", "navigateToMsg"), bVar.f(j3));
                return;
            }
        }
        long j16 = (30 + j3) - 1;
        if (this$0.q() != null) {
            com.tencent.aio.data.msglist.a q16 = this$0.q();
            Intrinsics.checkNotNull(q16);
            RangesKt___RangesKt.coerceAtMost(j16, q16.getMsgSeq());
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(30, (int) j16);
        AIOParam g18 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g18, "context.aioParam");
        QLog.i("GuildNavigateDelegate", 1, "navigateToMsg, channelId = " + com.tencent.guild.aio.util.a.b(g18) + ", getMsgsBySeqAndCount, endSeq = " + j16 + " count = " + coerceAtMost);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.t(new com.tencent.aio.msgservice.d(this$0.d().g().r(), j16, coerceAtMost, true)), new GuildDefaultNavigateDelegate$navigateToMsg$1$1(this$0, j3, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.r());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(final long msgSeq) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildNavigateDelegate", 1, "navigateToMsg, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", msgSeq = " + msgSeq);
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildDefaultNavigateDelegate.w(GuildDefaultNavigateDelegate.this, msgSeq);
            }
        }, null, 2, null);
    }

    public final void x(@Nullable v vVar) {
        this.mBeforeNavigateNotifier = vVar;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
