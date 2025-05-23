package com.tencent.guild.aio.component.combinestyle;

import android.view.View;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/q;", "Lcom/tencent/guild/aio/component/combinestyle/AbsGuildItemCombineStyleComponent;", "Lcom/tencent/guild/aio/component/combinestyle/GuildItemStyleMsgItem;", "msgItem", "Lcom/tencent/guild/aio/component/combinestyle/i;", "X1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Y1", "Lcom/tencent/guild/aio/component/combinestyle/ab;", "M", "Lcom/tencent/guild/aio/component/combinestyle/ab;", "getGuildCombineStylePushMsgItemProvider", "()Lcom/tencent/guild/aio/component/combinestyle/ab;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Lcom/tencent/guild/aio/component/combinestyle/ab;)V", "guildCombineStylePushMsgItemProvider", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "N", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class q extends AbsGuildItemCombineStyleComponent {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ab guildCombineStylePushMsgItemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull View root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent
    @Nullable
    public GuildMediaAioCombineStyleChain X1(@NotNull GuildItemStyleMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return msgItem.getGuildMediaAioCombineStyleChain();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent
    @Nullable
    public GuildMediaAioCombineStyleChain Y1(@NotNull GuildMsgItem msgItem) {
        af b16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ab abVar = this.guildCombineStylePushMsgItemProvider;
        if (abVar == null || (b16 = abVar.b(msgItem.getMsgRecord().msgType)) == null) {
            return null;
        }
        return b16.a(msgItem, this);
    }

    public final void a2(@Nullable ab abVar) {
        this.guildCombineStylePushMsgItemProvider = abVar;
    }
}
