package com.tencent.mobileqq.search.searchdetail;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0004H&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/d;", "", "Landroidx/lifecycle/LifecycleOwner;", "getLifecyclerOwner", "", "getDtAppKey", "getKeyword", "getTabName", "", "getTabMask", "", "getQuerySource", "getUserSource", "getPageMode", "getSessionId", "getSugTraceId", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "", "getPageCacheMap", "getStartSearchTimeStamps", "getAllItemNums", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "getPageType", "getMiniAppSessionId", "clickId", "", "onClickMiniApp", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface d {
    int getAllItemNums();

    @Nullable
    CoroutineScope getCoroutineScope();

    @Nullable
    String getDtAppKey();

    @NotNull
    String getKeyword();

    @NotNull
    LifecycleOwner getLifecyclerOwner();

    @NotNull
    String getMiniAppSessionId();

    @NotNull
    Map<String, Object> getPageCacheMap();

    int getPageMode();

    @NotNull
    SearchPageType getPageType();

    int getQuerySource();

    @NotNull
    String getSessionId();

    long getStartSearchTimeStamps();

    @NotNull
    String getSugTraceId();

    long getTabMask();

    @NotNull
    String getTabName();

    int getUserSource();

    void onClickMiniApp(@NotNull String clickId);
}
