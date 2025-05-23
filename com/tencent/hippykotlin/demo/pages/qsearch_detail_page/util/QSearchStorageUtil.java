package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.base.Utils;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchStorageUtil {
    public static final QSearchStorageUtil INSTANCE = new QSearchStorageUtil();

    public final int getHistoriesMaxCount() {
        Integer num = Utils.INSTANCE.cacheModule("").getInt("search_histories_max_count");
        if (num == null) {
            return 10;
        }
        Integer valueOf = Integer.valueOf(num.intValue());
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 10;
    }
}
