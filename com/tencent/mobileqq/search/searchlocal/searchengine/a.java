package com.tencent.mobileqq.search.searchlocal.searchengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.Metadata;
import lo2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/searchengine/a;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", IProfileCardConst.KEY_FROM_TYPE, "Lon2/b;", "Llo2/c;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    @NotNull
    public on2.b<c> a(@Nullable AppInterface app, int fromType) {
        return new NTSearchFunctionEngine(app, fromType);
    }
}
