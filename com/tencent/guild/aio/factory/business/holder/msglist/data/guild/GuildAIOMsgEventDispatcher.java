package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.util.NTServiceApiKt;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IGuildAIOFactoryApi;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR+\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildAIOMsgEventDispatcher;", "", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "", "e", "j", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/mobileqq/aio/msg/b;", "k", "msgItem", "", "d", tl.h.F, "i", "c", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "g", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "J", "mLastHasReadMsgSeq", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lkotlin/collections/ArrayList;", "Lkotlin/Lazy;", "f", "()Ljava/util/ArrayList;", "injectMsgProcessors", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAIOMsgEventDispatcher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mLastHasReadMsgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy injectMsgProcessors;

    public GuildAIOMsgEventDispatcher(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.aioContext = aioContext;
        this.scope = scope;
        this.mLastHasReadMsgSeq = -1L;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<AbsAIOMsgProcessor>>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildAIOMsgEventDispatcher$injectMsgProcessors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<AbsAIOMsgProcessor> invoke() {
                com.tencent.aio.api.runtime.a aVar;
                ArrayList<AbsAIOMsgProcessor> arrayList = new ArrayList<>();
                GuildAIOMsgEventDispatcher guildAIOMsgEventDispatcher = GuildAIOMsgEventDispatcher.this;
                IGuildAIOFactoryApi iGuildAIOFactoryApi = (IGuildAIOFactoryApi) QRoute.api(IGuildAIOFactoryApi.class);
                aVar = guildAIOMsgEventDispatcher.aioContext;
                arrayList.addAll(iGuildAIOFactoryApi.getGuildAIOMsgProcessor(aVar, guildAIOMsgEventDispatcher.getScope()));
                return arrayList;
            }
        });
        this.injectMsgProcessors = lazy;
    }

    private final boolean d(GuildMsgItem msgItem) {
        if (msgItem.getMsgSeq() <= this.mLastHasReadMsgSeq) {
            return true;
        }
        return false;
    }

    private final void e(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Object last;
        Object last2;
        if (this.mLastHasReadMsgSeq == -1) {
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
            long msgSeq = ((com.tencent.aio.data.msglist.a) last2).getMsgSeq();
            this.mLastHasReadMsgSeq = msgSeq;
            QLog.i("GuildMsgListRepo", 2, "init mLastHasReadMsgSeq seq=" + msgSeq);
        }
        Intrinsics.checkNotNull(displayList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.guild.api.data.msglist.GuildMsgItem>");
        List<com.tencent.mobileqq.aio.msg.b> k3 = k(displayList);
        Iterator<T> it = f().iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).a(k3);
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
        this.mLastHasReadMsgSeq = ((GuildMsgItem) last).getMsgSeq();
    }

    private final ArrayList<AbsAIOMsgProcessor> f() {
        return (ArrayList) this.injectMsgProcessors.getValue();
    }

    private final void j() {
        AIOParam g16 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        int e16 = com.tencent.guild.aio.util.a.e(g16);
        AIOParam g17 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g17);
        AIOParam g18 = this.aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(NTServiceApiKt.a(new GProContact(e16, b16, com.tencent.guild.aio.util.a.g(g18))), new GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), this.scope);
    }

    private final List<com.tencent.mobileqq.aio.msg.b> k(List<? extends GuildMsgItem> displayList) {
        ArrayList arrayList = new ArrayList();
        for (GuildMsgItem guildMsgItem : displayList) {
            arrayList.add(new com.tencent.mobileqq.aio.msg.b(d(guildMsgItem), guildMsgItem.getMsgRecord()));
        }
        QLog.i("GuildMsgListRepo", 2, "transToSpecialData mLastHasReadMsgSeq=" + this.mLastHasReadMsgSeq + " size=" + arrayList.size());
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<com.tencent.aio.data.msglist.a> c(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (!displayList.isEmpty()) {
            e(displayList);
        }
        return displayList;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void h() {
        Iterator<T> it = f().iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).d();
        }
        j();
    }

    public final void i() {
    }
}
