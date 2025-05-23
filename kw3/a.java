package kw3;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import com.tencent.qqnt.chats.main.vm.datasource.biz.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lkw3/a;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "userIntent", "", "M", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/biz/f;", "recentContactRepo", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/biz/f;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends ChatsListVM {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull f recentContactRepo) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 13), recentContactRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M */
    public void l(@NotNull b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        super.l(userIntent);
    }
}
