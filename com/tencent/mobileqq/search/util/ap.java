package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/search/util/ap;", "", "", "a", "<init>", "()V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ap f285014a = new ap();

    ap() {
    }

    @NotNull
    public final String a() {
        List list;
        List list2;
        List list3;
        List plus;
        List plus2;
        IntRange until;
        int collectionSizeOrDefault;
        String joinToString$default;
        Object random;
        list = CollectionsKt___CollectionsKt.toList(new CharRange(EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'Z'));
        list2 = CollectionsKt___CollectionsKt.toList(new CharRange('a', 'z'));
        list3 = CollectionsKt___CollectionsKt.toList(new CharRange('0', '9'));
        plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) list3);
        until = RangesKt___RangesKt.until(0, 10);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            random = CollectionsKt___CollectionsKt.random(plus2, Random.INSTANCE);
            arrayList.add(Character.valueOf(((Character) random).charValue()));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }
}
