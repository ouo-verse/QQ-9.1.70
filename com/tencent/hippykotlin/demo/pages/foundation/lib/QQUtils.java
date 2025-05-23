package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.kuikly.core.manager.c;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQUtils {
    public static final QQUtils INSTANCE = new QQUtils();

    public final int compare(String str) {
        List split$default;
        List split$default2;
        Object orNull;
        Integer intOrNull;
        Object orNull2;
        Integer intOrNull2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) c.f117352a.g().getPageData().getAppVersion(), new String[]{"."}, false, 0, 6, (Object) null);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        int max = Math.max(split$default.size(), split$default2.size());
        for (int i3 = 0; i3 < max; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, i3);
            String str2 = (String) orNull;
            if (str2 == null) {
                str2 = "0";
            }
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(split$default2, i3);
            String str3 = (String) orNull2;
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str3 != null ? str3 : "0");
            int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
            if (intValue < intValue2) {
                return -1;
            }
            if (intValue > intValue2) {
                return 1;
            }
        }
        return 0;
    }
}
