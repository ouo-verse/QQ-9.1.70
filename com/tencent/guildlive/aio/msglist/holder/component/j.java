package com.tencent.guildlive.aio.msglist.holder.component;

import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guildlive.aio.msglist.holder.component.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/j;", "Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveItemBaseVM;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "u", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j extends GuildLiveItemBaseVM {
    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectCountChangeEvent());
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof i.a) {
            z();
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    public void u(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            updateUI(new GuildMultiSelectModeChange(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode()));
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.GuildLiveItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName());
        return listOf;
    }
}
