package com.tencent.mobileqq.wink.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/au;", "", "", "url", "", "d", "", "b", "argumentStr", "a", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class au {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final au f326689a = new au();

    au() {
    }

    private final Map<String, String> a(String argumentStr) {
        List split$default;
        List split$default2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) argumentStr, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    String str = (String) split$default2.get(0);
                    String decode = URLDecoder.decode((String) split$default2.get(1));
                    Intrinsics.checkNotNullExpressionValue(decode, "decode(value)");
                    linkedHashMap.put(str, decode);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return linkedHashMap;
    }

    private final Map<String, String> b(String url) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = url.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return a(substring);
        }
        return new HashMap();
    }

    private final boolean d(String url) {
        boolean z16;
        int lastIndexOf$default;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        String str = b(url).get("t");
        if (str == null || !Intrinsics.areEqual(str, "6")) {
            if (str != null) {
                return false;
            }
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, "&t=6#sce", 0, false, 6, (Object) null);
            if (lastIndexOf$default <= 0) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String c(@NotNull String url) {
        String replace$default;
        Intrinsics.checkNotNullParameter(url, "url");
        if (d(url)) {
            replace$default = StringsKt__StringsJVMKt.replace$default(url, "t=6", "t=5", false, 4, (Object) null);
            return replace$default;
        }
        return url;
    }
}
