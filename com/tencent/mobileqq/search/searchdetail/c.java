package com.tencent.mobileqq.search.searchdetail;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0000H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/c;", "", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "e", "", "i", WidgetCacheConstellationData.NUM, "c", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface c {
    boolean a(@NotNull c newItem);

    boolean b(@NotNull c newItem);

    void c(int num);

    @Nullable
    Object e(@NotNull c newItem);

    @NotNull
    String getItemId();

    int getItemType();

    void i();
}
