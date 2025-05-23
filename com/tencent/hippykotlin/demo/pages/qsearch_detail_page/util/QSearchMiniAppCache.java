package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import c01.c;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMiniAppCache {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QSearchMiniAppCache.class, "miniAppCache", "getMiniAppCache()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public static final QSearchMiniAppCache INSTANCE = new QSearchMiniAppCache();
    public static final ReadWriteProperty miniAppCache$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<String> getMiniAppCache() {
        return (com.tencent.kuikly.core.reactive.collection.c) miniAppCache$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void readCacheIfNeed() {
        List split$default;
        if (!getMiniAppCache().isEmpty()) {
            return;
        }
        String item = Utils.INSTANCE.cacheModule("").getItem("show_mini_app_list");
        if (item.length() > 0) {
            com.tencent.kuikly.core.reactive.collection.c<String> miniAppCache = getMiniAppCache();
            split$default = StringsKt__StringsKt.split$default((CharSequence) item, new String[]{","}, false, 0, 6, (Object) null);
            miniAppCache.addAll(split$default);
        }
    }
}
