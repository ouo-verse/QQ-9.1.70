package com.tencent.guild.aio.halfpop.menu;

import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/x;", "Lcom/tencent/guild/aio/halfpop/menu/ReplyActionItem;", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class x extends ReplyActionItem {
    public x() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ x(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.qui_quote, R.string.f16496279) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
