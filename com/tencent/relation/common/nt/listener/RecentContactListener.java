package com.tencent.relation.common.nt.listener;

import com.tencent.mobileqq.data.RecentUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "onResult", "", "recentUserList", "", "Lcom/tencent/mobileqq/data/RecentUser;", "relation-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface RecentContactListener {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class DefaultImpls {
        public static void onResult(@NotNull RecentContactListener recentContactListener, @NotNull List<RecentUser> recentUserList) {
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
        }
    }

    void onResult(@NotNull List<RecentUser> recentUserList);
}
