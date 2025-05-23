package com.tencent.gdtad.util;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00022\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001aM\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u0001`\n2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"E", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", ReportConstant.COSTREPORT_PREFIX, "", "a", "(Ljava/util/HashSet;Ljava/lang/Object;)V", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "l", "b", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)V", "qqad-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {
    public static final <E> void a(@Nullable HashSet<E> hashSet, E e16) {
        int i3;
        if (hashSet != null) {
            i3 = hashSet.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 200 && hashSet != null) {
            hashSet.clear();
        }
        if (hashSet != null) {
            hashSet.add(e16);
        }
    }

    public static final <K, V> void b(@Nullable HashMap<K, V> hashMap, K k3, V v3) {
        int i3;
        if (hashMap != null) {
            i3 = hashMap.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 200 && hashMap != null) {
            hashMap.clear();
        }
        if (hashMap != null) {
            hashMap.put(k3, v3);
        }
    }
}
