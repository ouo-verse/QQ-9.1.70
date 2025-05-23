package com.tencent.mobileqq.guild.feed.morepanel;

import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "c", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {
    @Nullable
    public static final CoroutineScope b(@NotNull com.tencent.mobileqq.guild.feed.util.framework.route.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        FeedMorePanelBusiImpl.OperationListProvider.d dVar = (FeedMorePanelBusiImpl.OperationListProvider.d) aVar.b(FeedMorePanelBusiImpl.OperationListProvider.d.class);
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public static final void c(@NotNull com.tencent.mobileqq.guild.feed.util.framework.route.a aVar, @NotNull final CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        aVar.a(FeedMorePanelBusiImpl.OperationListProvider.d.class, new FeedMorePanelBusiImpl.OperationListProvider.d() { // from class: com.tencent.mobileqq.guild.feed.morepanel.h
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.d
            public final CoroutineScope a() {
                CoroutineScope d16;
                d16 = i.d(CoroutineScope.this);
                return d16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope d(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "$scope");
        return scope;
    }
}
