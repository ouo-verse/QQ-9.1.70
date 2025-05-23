package com.tencent.mobileqq.startup.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "", "", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
    
        if (java.lang.Integer.parseInt(r2) >= 1000) goto L16;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<Integer> a(@NotNull String str) {
        List split$default;
        int collectionSizeOrDefault;
        boolean z16;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{",", "{", "}", "[", "]"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            String str2 = (String) obj;
            boolean z17 = true;
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
                if (intOrNull != null) {
                }
            }
            z17 = false;
            if (z17) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        return arrayList2;
    }
}
