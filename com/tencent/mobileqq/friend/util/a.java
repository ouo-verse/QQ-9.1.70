package com.tencent.mobileqq.friend.util;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/friend/util/a;", "", "", "key", "", "timeGap", "", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "lastClickTimeMap", "a", "()Z", "isDoubleClick", "<init>", "()V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f211732a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Long> lastClickTimeMap = new HashMap<>();

    a() {
    }

    public final synchronized boolean a() {
        return b("default", 500L);
    }

    public final boolean b(String key, long timeGap) {
        Long l3;
        Intrinsics.checkNotNullParameter(key, "key");
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = lastClickTimeMap;
        if (hashMap.containsKey(key)) {
            Long l16 = hashMap.get(key);
            Intrinsics.checkNotNull(l16);
            l3 = l16;
        } else {
            l3 = 0L;
        }
        Intrinsics.checkNotNullExpressionValue(l3, "if (lastClickTimeMap.con\u2026lickTimeMap[key]!! else 0");
        long longValue = currentTimeMillis - l3.longValue();
        boolean z16 = false;
        if (0 <= longValue && longValue <= timeGap) {
            z16 = true;
        }
        hashMap.put(key, Long.valueOf(currentTimeMillis));
        return z16;
    }
}
