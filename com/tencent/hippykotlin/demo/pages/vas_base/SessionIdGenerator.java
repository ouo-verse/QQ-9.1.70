package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.kuikly.core.manager.BridgeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SessionIdGenerator {
    public static final SessionIdGenerator INSTANCE = new SessionIdGenerator();
    public static final Map<String, String> map = new LinkedHashMap();

    public final String generateRandomString(int i3) {
        List plus;
        int collectionSizeOrDefault;
        String joinToString$default;
        Object random;
        plus = CollectionsKt___CollectionsKt.plus((Iterable) new CharRange('a', 'f'), (Iterable) new CharRange('0', '9'));
        IntRange intRange = new IntRange(1, i3);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            random = CollectionsKt___CollectionsKt.random(plus, Random.INSTANCE);
            arrayList.add(Character.valueOf(((Character) random).charValue()));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    public final String getSessionId() {
        ?? r06 = map;
        String u16 = BridgeManager.f117344a.u();
        Object obj = r06.get(u16);
        if (obj == null) {
            obj = INSTANCE.generateRandomString(32);
            r06.put(u16, obj);
        }
        return (String) obj;
    }
}
