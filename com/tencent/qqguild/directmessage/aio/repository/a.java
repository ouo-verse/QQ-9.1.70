package com.tencent.qqguild.directmessage.aio.repository;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildDefaultNavigateDelegate;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/repository/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "", "c", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "notifyAction", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "model", "j", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", ReportConstant.COSTREPORT_PREFIX, "displayList", "k", "", "msgSeq", h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "getHost", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Laq0/a;", "g", "Laq0/a;", "combineMsgCenter", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildDefaultNavigateDelegate;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildDefaultNavigateDelegate;", "navigateDelegate", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aq0.a combineMsgCenter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildDefaultNavigateDelegate navigateDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.combineMsgCenter = new aq0.a();
        this.navigateDelegate = new GuildDefaultNavigateDelegate(host);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        this.navigateDelegate.h(msgSeq);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void j(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.j(model);
        this.navigateDelegate.j(model);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        boolean z16;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : displayList) {
            if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(sortedWith);
        this.combineMsgCenter.g(copyOnWriteArrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : copyOnWriteArrayList) {
            com.tencent.aio.data.msglist.a msg2 = (com.tencent.aio.data.msglist.a) obj2;
            MsgListRepo msgListRepo = this.host;
            Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            ((GuildMsgListRepo) msgListRepo).k1(msg2);
            if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().i("Guild.C2C.AIO.MsgListRepoDelegate", 1, "beforeMsgToScreen, filter msg class = " + msg2.getClass() + ", seq = " + msg2.getMsgSeq());
            }
            if (z16) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        this.navigateDelegate.l(context, scope);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void m(@Nullable Function1<? super l, Unit> notifyAction) {
        Logger.f235387a.d().i("Guild.C2C.AIO.MsgListRepoDelegate", 1, "setUpdateNotify");
        super.m(notifyAction);
        this.navigateDelegate.m(notifyAction);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        super.onDestroy();
        this.navigateDelegate.onDestroy();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public List<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Object firstOrNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "list");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = this.host.E();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
        E.f((com.tencent.aio.data.msglist.a) firstOrNull);
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            com.tencent.aio.data.msglist.a msg2 = (com.tencent.aio.data.msglist.a) obj;
            MsgListRepo msgListRepo = this.host;
            Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            ((GuildMsgListRepo) msgListRepo).k1(msg2);
            if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().i("Guild.C2C.AIO.MsgListRepoDelegate", 1, "beforeMsgAddToMemory, filter msg class = " + msg2.getClass() + ", seq = " + msg2.getMsgSeq());
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
