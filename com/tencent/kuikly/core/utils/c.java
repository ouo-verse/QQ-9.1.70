package com.tencent.kuikly.core.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000*\"\u0010\u0005\"\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00042\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0004\u00a8\u0006\u0006"}, d2 = {"", "url", "", "a", "Lkotlin/Pair;", "UrlParamEntry", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {
    public static final Map<String, String> a(String url) {
        List split$default;
        Object last;
        List split$default2;
        List split$default3;
        Object first;
        Object last2;
        Intrinsics.checkNotNullParameter(url, "url");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) last, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        Iterator it = split$default2.iterator();
        while (it.hasNext()) {
            split$default3 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            if (split$default3.size() == 2) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default3);
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default3);
                linkedHashMap.put((String) first, (String) last2);
            }
        }
        return linkedHashMap;
    }
}
