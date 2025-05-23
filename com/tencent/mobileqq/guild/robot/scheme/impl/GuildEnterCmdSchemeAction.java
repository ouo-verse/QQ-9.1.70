package com.tencent.mobileqq.guild.robot.scheme.impl;

import android.net.Uri;
import com.tencent.aio.api.runtime.a;
import com.tencent.guild.aio.util.e;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CoroutineScope;
import n14.b;
import n14.c;
import org.jetbrains.annotations.NotNull;
import rq0.GuildRobotSchemeActionContext;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/robot/scheme/impl/GuildEnterCmdSchemeAction;", "Ln14/b;", "Lrq0/a;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "cmdName", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "Lsr0/b;", "f", "ctx", "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "", "e", "Ln14/c;", "c", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildEnterCmdSchemeAction extends b<GuildRobotSchemeActionContext> {
    /* JADX INFO: Access modifiers changed from: private */
    public final List<sr0.b> f(a context, String cmdName, GuildMsgItem msgItem) {
        List<sr0.b> emptyList;
        Long longOrNull;
        long j3;
        List<sr0.b> plus;
        if (com.tencent.guild.aio.util.ex.a.i(context)) {
            return e.g(e.f112380a, cmdName, 0, 0L, 0L, null, 30, null);
        }
        if (msgItem == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        e eVar = e.f112380a;
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String str3 = "@" + iq0.a.u(str, str2);
        String str4 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.senderUid");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str4);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) e.g(eVar, str3, 2, 0L, j3, null, 20, null), (Iterable) e.g(eVar, " " + cmdName, 0, 0L, 0L, null, 30, null));
        return plus;
    }

    @Override // n14.b
    public boolean c(@NotNull c ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ctx instanceof GuildRobotSchemeActionContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n14.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull GuildRobotSchemeActionContext ctx, @NotNull Uri scheme) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            Boolean bool = Boolean.FALSE;
            CorountineFunKt.e(f16, "GuildEnterCmdSchemeAction_handleSendInlineCmd", bool, null, bool, new GuildEnterCmdSchemeAction$doAction$1(ctx, this, scheme, null), 4, null);
            return true;
        }
        return true;
    }
}
