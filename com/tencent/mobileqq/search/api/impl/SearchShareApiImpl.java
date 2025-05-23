package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchShareApi;
import kn2.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchShareApiImpl;", "Lcom/tencent/mobileqq/search/api/ISearchShareApi;", "Lmqq/app/AppRuntime;", "app", "", "resourceId", "actionId", "Lkn2/e;", "shareCallback", "", "getShareInfo", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchShareApiImpl implements ISearchShareApi {
    @Override // com.tencent.mobileqq.search.api.ISearchShareApi
    public void getShareInfo(@Nullable AppRuntime app, @Nullable String resourceId, @NotNull String actionId, @NotNull e shareCallback) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        vp2.a.f443148a.a(app, resourceId, actionId, shareCallback);
    }
}
