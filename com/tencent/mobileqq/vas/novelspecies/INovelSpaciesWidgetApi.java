package com.tencent.mobileqq.vas.novelspecies;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.novelspecies.data.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/INovelSpaciesWidgetApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "fetchAndCacheWidgetData", "Lcom/tencent/mobileqq/vas/novelspecies/data/a;", "getWidgetCachedData", "", "isAddedWidget", "cleanImageCache", "cleanCachedData", "vas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface INovelSpaciesWidgetApi extends QRouteApi {
    void cleanCachedData();

    void cleanImageCache();

    void fetchAndCacheWidgetData();

    @Nullable
    a getWidgetCachedData();

    boolean isAddedWidget();
}
