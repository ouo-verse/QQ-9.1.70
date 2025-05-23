package com.tencent.qqnt.chats.biz.guildhelper;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import com.tencent.qqnt.chats.main.vm.datasource.biz.GuildHelperChatsRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guildhelper/e;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo;", "recentContactRepo", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e extends ChatsListVM {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull GuildHelperChatsRepo recentContactRepo) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 60), recentContactRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }
}
