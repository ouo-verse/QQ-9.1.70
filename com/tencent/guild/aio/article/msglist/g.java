package com.tencent.guild.aio.article.msglist;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 %2\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/g;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "b0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", "L", "", "source", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "k", "", "list", "b", "a", "e", "", "beginMsgSeq", "endMsgSeq", "f", "o", "msgSeq", tl.h.F, "com/tencent/guild/aio/article/msglist/g$b", "l", "Lcom/tencent/guild/aio/article/msglist/g$b;", "action", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends MsgListRepo {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/g$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            g.this.b0(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.action = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(MsgIntent i3) {
        if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToMsgEvent) {
            A(((GuildMsgNavigateEvent.GuildNavigateToMsgEvent) i3).getMsgSeq());
        } else if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent) {
            z();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void L() {
        super.L();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        super.Q();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(list, "list");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
        return sortedWith;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        return displayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void c() {
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
    }
}
