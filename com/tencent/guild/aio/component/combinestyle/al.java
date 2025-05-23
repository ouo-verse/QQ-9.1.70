package com.tencent.guild.aio.component.combinestyle;

import android.util.Log;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Lcom/tencent/guild/aio/component/combinestyle/StyleGuildItemMsg;", "data", "", "listIsAtBottom", "", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class al {
    public static final void b(@NotNull final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k kVar, @NotNull final MsgListRepo host, @NotNull final StyleGuildItemMsg data, final boolean z16) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(data, "data");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.component.combinestyle.ak
            @Override // java.lang.Runnable
            public final void run() {
                al.c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k.this, data, host, z16);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k this_handleLocalCombineStyle, StyleGuildItemMsg data, MsgListRepo host, boolean z16) {
        Object lastOrNull;
        GuildMsgItem guildMsgItem;
        long j3;
        Intrinsics.checkNotNullParameter(this_handleLocalCombineStyle, "$this_handleLocalCombineStyle");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(host, "$host");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this_handleLocalCombineStyle.g());
        if (lastOrNull instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) lastOrNull;
        } else {
            guildMsgItem = null;
        }
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        if (guildMsgItem != null) {
            j3 = guildMsgItem.getMsgSeq();
        } else {
            j3 = 0;
        }
        GuildItemStyleMsgItem guildItemStyleMsgItem = new GuildItemStyleMsgItem(data.getGuildMediaAioCombineStyleChain(), iMsgUtilApi.createMsgItem(arrayList, "", "", 0, 0, j3, "", 0L, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).generateMsgUniqueId()).a());
        this_handleLocalCombineStyle.g().add((com.tencent.aio.data.msglist.a) guildItemStyleMsgItem);
        host.E().i(guildItemStyleMsgItem);
        host.E().k(guildItemStyleMsgItem);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("MsgListRepoDelegateKt", "[handleLocalCombineStyle] " + data.getGuildMediaAioCombineStyleChain().getEnableScrollUp() + "\uff0c" + z16);
        }
        if (!data.getGuildMediaAioCombineStyleChain().getEnableScrollUp() && !z16) {
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, host, data.getGuildMediaAioCombineStyleChain().getAioListOpType(), this_handleLocalCombineStyle.g(), bVar.e("MsgListRepoDelegate", "handleLocalCombineStyle"), null, 16, null);
        } else {
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar2.p(host, data.getGuildMediaAioCombineStyleChain().getAioListOpType(), this_handleLocalCombineStyle.g(), bVar2.e("MsgListRepoDelegate", "handleLocalCombineStyle"), bVar2.b(false, data.getGuildMediaAioCombineStyleChain().getEnableScrollUp()));
        }
    }
}
