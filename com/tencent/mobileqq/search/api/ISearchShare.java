package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.SearchShareInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchShare;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", "context", "Landroid/view/View;", "logicParentView", "Lcom/tencent/mobileqq/search/ad;", "shareInfo", "", "share", "qqsearch-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchShare extends QRouteApi {
    void share(@NotNull Activity context, @Nullable View logicParentView, @NotNull SearchShareInfo shareInfo);
}
