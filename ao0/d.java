package ao0;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\rH\u0002J&\u0010\u0014\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000eJ.\u0010\u0015\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000eR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lao0/d;", "", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Landroid/content/Context;", "context", "", "c", "msgItem", "f", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "g", "k", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "delayParseRestList", h.F, "i", "Lao0/f;", "b", "Ljava/util/List;", "parserList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f26594a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<f> parserList;

    static {
        List<f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new a(), new e()});
        parserList = listOf;
    }

    d() {
    }

    private final void c(final List<? extends com.tencent.aio.data.msglist.a> displayList, final AIOParam aioParam, final Context context) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: ao0.b
            @Override // java.lang.Runnable
            public final void run() {
                d.d(displayList, aioParam, context);
            }
        }, 16, null, true, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final List displayList, final AIOParam aioParam, final Context context) {
        Intrinsics.checkNotNullParameter(displayList, "$displayList");
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: ao0.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e(displayList, aioParam, context);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List displayList, AIOParam aioParam, Context context) {
        Intrinsics.checkNotNullParameter(displayList, "$displayList");
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        QLog.i("GuildMsgPreParseUtil", 1, "delayPreParseRestList. list size: " + displayList.size());
        Iterator it = displayList.iterator();
        while (it.hasNext()) {
            f26594a.f((com.tencent.aio.data.msglist.a) it.next(), aioParam, context);
        }
    }

    private final void f(com.tencent.aio.data.msglist.a msgItem, AIOParam aioParam, Context context) {
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            if (!g(guildMsgItem)) {
                for (f fVar : parserList) {
                    g12.b bVar = g12.b.f401087a;
                    GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_MSG_PRE_PARSE_TIME_COST;
                    bVar.h(guildHistogramScene, fVar.getTag());
                    if (fVar.a(guildMsgItem)) {
                        fVar.b(guildMsgItem, context, aioParam);
                    }
                    bVar.a(guildHistogramScene, fVar.getTag());
                }
                k(guildMsgItem);
            }
        }
    }

    private final boolean g(GuildMsgItem msgItem) {
        return msgItem.getPreParseInfo().getPreParsed();
    }

    public static /* synthetic */ void j(d dVar, List list, com.tencent.aio.api.runtime.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        dVar.h(list, aVar, z16);
    }

    private final void k(GuildMsgItem msgItem) {
        msgItem.getPreParseInfo().n(true);
    }

    public final void h(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @NotNull com.tencent.aio.api.runtime.a aioContext, boolean delayParseRestList) {
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        i(displayList, g16, aioContext.c().getContext(), delayParseRestList);
    }

    public final void i(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @NotNull AIOParam aioParam, @Nullable Context context, boolean delayParseRestList) {
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        QLog.i("GuildMsgPreParseUtil", 1, "preParseMsgList. list size: " + displayList.size() + ", delayParseRestList " + delayParseRestList);
        long currentTimeMillis = System.currentTimeMillis();
        TraceUtils.h("msgPreParse");
        if (displayList.size() > 15) {
            Iterator<T> it = displayList.subList(displayList.size() - 15, displayList.size()).iterator();
            while (it.hasNext()) {
                f26594a.f((com.tencent.aio.data.msglist.a) it.next(), aioParam, context);
            }
            if (delayParseRestList) {
                c(displayList, aioParam, context);
            }
        } else {
            Iterator<T> it5 = displayList.iterator();
            while (it5.hasNext()) {
                f26594a.f((com.tencent.aio.data.msglist.a) it5.next(), aioParam, context);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildMsgPreParseUtil", 2, "preParseMsgList finished. cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        TraceUtils.k();
    }
}
