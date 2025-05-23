package com.tencent.mobileqq.zplan.api;

import android.content.Context;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZplanCacheApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "context", "Landroid/content/Context;", "uniquePageKey", "", "getCache", "", "cacheType", "Lcom/tencent/mobileqq/zplan/api/ZplanCacheComponentType;", "saveCache", "cacheObj", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZplanCacheApi extends QRouteApi {
    void clearCache(@NotNull Context context);

    void clearCache(@NotNull String uniquePageKey);

    @Nullable
    Object getCache(@NotNull Context context, @NotNull ZplanCacheComponentType cacheType);

    @Nullable
    Object getCache(@NotNull String uniquePageKey, @NotNull ZplanCacheComponentType cacheType);

    void saveCache(@NotNull Context context, @NotNull ZplanCacheComponentType cacheType, @NotNull Object cacheObj);

    void saveCache(@NotNull String uniquePageKey, @NotNull ZplanCacheComponentType cacheType, @NotNull Object cacheObj);
}
