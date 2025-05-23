package com.tencent.mobileqq.guild.live.danmu.dispatch;

import android.os.Bundle;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.live.danmu.item.GLiveDanmuPriority;
import com.tencent.mobileqq.guild.live.viewmodel.GLiveDanmuLogicVM;
import com.tencent.mobileqq.guild.util.Logger;
import fn0.GuildLiveAioMsgListWrap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jq1.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/dispatch/d;", "Lfn0/c;", "", "k", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "g", "f", "e", "", "displayList", "i", "d", "c", "Lfn0/b;", "data", "L0", "", "event", "Landroid/os/Bundle;", "extra", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "logicVM", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "msgCacheQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "msgSeqSet", h.F, "J", "enterTime", "<init>", "(Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements fn0.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveDanmuLogicVM logicVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<GuildLiveAioMsgListWrap> msgCacheQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile HashSet<Long> msgSeqSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long enterTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    public d(@NotNull GLiveDanmuLogicVM logicVM) {
        Intrinsics.checkNotNullParameter(logicVM, "logicVM");
        this.logicVM = logicVM;
        this.msgCacheQueue = new LinkedList<>();
        this.msgSeqSet = new HashSet<>();
    }

    private final boolean e(com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        boolean z16 = false;
        if (guildMsgItem == null) {
            return false;
        }
        if (guildMsgItem.getMsgRecord().sendStatus == 2 || guildMsgItem.getMsgRecord().sendStatus == 3) {
            z16 = true;
        }
        if (!guildMsgItem.isLocalSend()) {
            return true;
        }
        return z16;
    }

    private final boolean f(com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem == null || guildMsgItem.getMsgRecord().msgTime * 1000 <= this.enterTime) {
            return false;
        }
        return true;
    }

    private final boolean g(com.tencent.aio.data.msglist.a msgItem) {
        if (!f(msgItem) || this.msgSeqSet.contains(Long.valueOf(msgItem.getMsgSeq()))) {
            return false;
        }
        this.msgSeqSet.add(Long.valueOf(msgItem.getMsgSeq()));
        return e(msgItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    private final void i(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        GuildMsgItem guildMsgItem;
        jq1.a aVar;
        e b16;
        if (displayList.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar2 : displayList) {
            if (aVar2 instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar2;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null && (b16 = (aVar = jq1.a.f410847a).b(aVar2.getViewType())) != null && b16.a()) {
                com.tencent.mobileqq.guild.live.danmu.item.a b17 = b16.b(guildMsgItem);
                b17.j(aVar.a(aVar2.getViewType()));
                if (b17.i()) {
                    b17.j(GLiveDanmuPriority.HIGH);
                }
                arrayList.add(b17);
            }
        }
        if (!arrayList.isEmpty()) {
            GLiveDanmuLogicVM.Q1(this.logicVM, new Runnable() { // from class: com.tencent.mobileqq.guild.live.danmu.dispatch.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(d.this, arrayList);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, ArrayList danmuItemList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(danmuItemList, "$danmuItemList");
        this$0.logicVM.getDanmuStore().c(danmuItemList);
    }

    private final void k() {
        List<? extends com.tencent.aio.data.msglist.a> sortedWith;
        Iterator<GuildLiveAioMsgListWrap> it = this.msgCacheQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "msgCacheQueue.iterator()");
        while (it.hasNext()) {
            GuildLiveAioMsgListWrap next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            List<com.tencent.aio.data.msglist.a> a16 = next.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (g((com.tencent.aio.data.msglist.a) obj)) {
                    arrayList.add(obj);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
            it.remove();
            if (!sortedWith.isEmpty()) {
                i(sortedWith);
            }
        }
    }

    @Override // fn0.c
    public void L0(@NotNull GuildLiveAioMsgListWrap data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.msgCacheQueue.add(data);
        GLiveDanmuLogicVM.Q1(this.logicVM, new Runnable() { // from class: com.tencent.mobileqq.guild.live.danmu.dispatch.b
            @Override // java.lang.Runnable
            public final void run() {
                d.h(d.this);
            }
        }, 0L, 2, null);
    }

    public final void c() {
        Logger.f235387a.d().d("QGL.GuildLiveDanmuProducer", 1, "[destroy] ");
        this.enterTime = 0L;
        this.msgSeqSet.clear();
        this.msgCacheQueue.clear();
    }

    public final void d() {
        Logger.f235387a.d().d("QGL.GuildLiveDanmuProducer", 1, "[init] ");
        this.enterTime = System.currentTimeMillis();
    }

    @Override // fn0.c
    public void x(int event, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        if (event == fn0.a.f399890a.b()) {
            this.enterTime = System.currentTimeMillis();
            Logger.f235387a.d().d("QGL.GuildLiveDanmuProducer", 1, "[onReceiveEvent] ENTER_FROM_FLOAT_WINDOW update enterTime!");
        }
    }
}
