package com.tencent.mobileqq.mini.model;

import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/model/DetainConfigMatchHelper;", "", "()V", "find", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "curPageUrl", "", "list", "", "isItemMatch", "", VasWebviewConstants.KEY_PAGE_URL, "itemPath", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DetainConfigMatchHelper {
    public final AppDetainConfig find(String curPageUrl, List<AppDetainConfig> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(curPageUrl, "curPageUrl");
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (isItemMatch(curPageUrl, ((AppDetainConfig) obj2).getExitPage())) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                String exitPage = ((AppDetainConfig) next).getExitPage();
                int length = exitPage != null ? exitPage.length() : 0;
                do {
                    Object next2 = it.next();
                    String exitPage2 = ((AppDetainConfig) next2).getExitPage();
                    int length2 = exitPage2 != null ? exitPage2.length() : 0;
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (AppDetainConfig) obj;
    }

    private final boolean isItemMatch(String pageUrl, String itemPath) {
        boolean endsWith$default;
        String substringBefore$default;
        String removePrefix;
        String removePrefix2;
        String substringBeforeLast$default;
        boolean startsWith$default;
        if (itemPath == null || itemPath.length() == 0) {
            return false;
        }
        if (Intrinsics.areEqual(itemPath, "*")) {
            return true;
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(itemPath, "/*", false, 2, null);
        if (endsWith$default) {
            substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(itemPath, "*", (String) null, 2, (Object) null);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pageUrl, substringBeforeLast$default, false, 2, null);
            return startsWith$default;
        }
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(pageUrl, ".html", (String) null, 2, (Object) null);
        removePrefix = StringsKt__StringsKt.removePrefix(substringBefore$default, (CharSequence) "/");
        removePrefix2 = StringsKt__StringsKt.removePrefix(itemPath, (CharSequence) "/");
        return Intrinsics.areEqual(removePrefix, removePrefix2);
    }
}
