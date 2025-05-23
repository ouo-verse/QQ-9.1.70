package com.tencent.guildmedia.aio.msglist.holder;

import android.view.View;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAvatarComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleMsgItemComponentProvider;
import com.tencent.guildmedia.aio.msglist.holder.component.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/GuildMediaMsgItemComponentProvider;", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaCombineStyleMsgItemComponentProvider;", "root", "Landroid/view/View;", "(Landroid/view/View;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildMediaMsgItemComponentProvider extends GuildMediaCombineStyleMsgItemComponentProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaMsgItemComponentProvider(@NotNull final View root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
        h(new Function1<View, GuildMediaAvatarComponent>() { // from class: com.tencent.guildmedia.aio.msglist.holder.GuildMediaMsgItemComponentProvider.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GuildMediaAvatarComponent invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GuildMediaAvatarComponent(root);
            }
        });
        l(new Function1<View, e>() { // from class: com.tencent.guildmedia.aio.msglist.holder.GuildMediaMsgItemComponentProvider.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final e invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new e(root);
            }
        });
    }
}
