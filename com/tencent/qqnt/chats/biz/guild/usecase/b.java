package com.tencent.qqnt.chats.biz.guild.usecase;

import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.longclick.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/usecase/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b$a;", "params", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements com.tencent.qqnt.chats.main.vm.usecase.longclick.b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.longclick.b
    public boolean a(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b a16 = params.a();
        if (a16 instanceof g) {
            gVar = (g) a16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.longclick.b
    @Nullable
    public com.tencent.qqnt.chats.main.vm.usecase.result.a b(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return null;
    }
}
