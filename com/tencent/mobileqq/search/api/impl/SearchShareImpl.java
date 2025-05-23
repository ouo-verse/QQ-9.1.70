package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.search.SearchShareInfo;
import com.tencent.mobileqq.search.api.ISearchShare;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchShareImpl;", "Lcom/tencent/mobileqq/search/api/ISearchShare;", "Landroid/app/Activity;", "context", "Landroid/view/View;", "logicParentView", "Lcom/tencent/mobileqq/search/ad;", "shareInfo", "", "share", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchShareImpl implements ISearchShare {
    @Override // com.tencent.mobileqq.search.api.ISearchShare
    public void share(@NotNull Activity context, @Nullable View logicParentView, @NotNull SearchShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        new SearchActionSheet(context, logicParentView, shareInfo).s();
    }
}
