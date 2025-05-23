package com.tencent.mobileqq.guildhelper;

import android.content.Context;
import com.tencent.mobileqq.guildhelper.GuildHelperFragment;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guildhelper/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 60) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params.b() instanceof g)) {
            return false;
        }
        GuildHelperFragment.Companion companion = GuildHelperFragment.INSTANCE;
        Context context = params.c().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "params.view.context");
        companion.a(context);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
